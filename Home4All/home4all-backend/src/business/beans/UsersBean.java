package business.beans;

import business.Utils;
import business.entities.*;
import business.exceptions.GenderNotExistentException;
import business.exceptions.OccupationNotExistentException;
import data.*;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import javax.ejb.Stateless;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Stateless(name = "UsersEJB")
public class UsersBean implements UsersBeanLocal {
    private static PersistentSession session = null;

    public UsersBean() {
    }

    private PersistentSession getSession() {
        if (session == null) {
            try {
                session = Home4AllPersistentManager.instance().getSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return session;
    }

    @Override
    public Users login(String email, String password) throws PersistentException {
        PersistentSession s = getSession();
        return UsersDAO.loadUsersByQuery(s,"email='"+email+"' AND password='"+ Utils.hash(password)+"'", null);
    }

    @Override
    public List<Users> listUsers() throws PersistentException {
        PersistentSession s = getSession();
        Users[] users = data.UsersDAO.listUsersByQuery(s,null, null);
        return new ArrayList<>(Arrays.asList(users));
    }

    @Override
    public Common insertCommonUser(String email, String name, String password, String birthdate, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException,
            OccupationNotExistentException, ParseException {
        PersistentSession s = getSession();
        PersistentTransaction t = s.beginTransaction();
        try {
            Common user;
            if (password != null) {
                user = InternalAccountDAO.createInternalAccount();
                ((InternalAccount) user).setPassword(Utils.hash(password));
            } else {
                user = CommonDAO.createCommon();
            }
            Gender genderValue;
            System.out.println(gender);
            System.out.println(occupation);
            if (gender != null) {
                genderValue = GenderDAO.loadGenderByORMID(s,gender);
                if (genderValue == null)
                    throw new GenderNotExistentException();
            } else {
                throw new GenderNotExistentException();
            }
            Occupation occupationValue;
            if (occupation != null) {
                occupationValue = OccupationDAO.loadOccupationByORMID(s,occupation);
                if (occupationValue == null)
                    throw new OccupationNotExistentException();
            } else {
                throw new OccupationNotExistentException();
            }
            System.out.println(genderValue);
            System.out.println(occupationValue);
            user.setEmail(email);
            user.setName(name);
            user.setPhone(phone);

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthdate(format.parse(birthdate));
            user.setGender(genderValue);
            user.setOccupation(occupationValue);
            user.setLastLogin(new Date());
            user.setBlocked(false);
            s.save(user);
            t.commit();
            return user;
        }
        catch (Exception e) {
                t.rollback();
                throw e;
            }

    }

    @Override

    public Common updateCommonUser(int id, String name, String password, String birthdate, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException,
            OccupationNotExistentException, ParseException {
        PersistentSession s = getSession();
        PersistentTransaction t = s.beginTransaction();
        try {
            Common user;
            user = CommonDAO.getCommonByORMID(s,id);
            System.out.println(user.getID());
            Gender genderValue;
            if (gender != null) {
                genderValue = GenderDAO.loadGenderByORMID(s,gender);
                if (genderValue == null)
                    throw new GenderNotExistentException();
                else
                    user.setGender(genderValue);

            }

            Occupation occupationValue;
            if (occupation != null) {
                occupationValue = OccupationDAO.loadOccupationByORMID(s,occupation);
                if (occupationValue == null)
                    throw new OccupationNotExistentException();
                else
                    user.setOccupation(occupationValue);
            }
            if (password!= null){
                InternalAccount user_internal = InternalAccountDAO.getInternalAccountByORMID(s,id);
                user_internal.setPassword(Utils.hash(password));
            }

            if (name != null)
                user.setName(name);
            if (phone != null)
                user.setPhone(phone);
            if (birthdate != null) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                user.setBirthdate(format.parse(birthdate));
            }
            s.save(user);
            s.save(user);
            t.commit();
            return user;
        }
        catch (Exception e) {
            t.rollback();
            throw e;
        }
    }

    public Common getUser(int ID) throws PersistentException {
        PersistentSession session = getSession();
        return CommonDAO.getCommonByORMID(session, ID);
    }

    public Users getUserbyUsers(int ID) throws PersistentException {
        PersistentSession session = getSession();
        return UsersDAO.getUsersByORMID(session, ID);
    }

    public Map<String, Map.Entry<Long,Long>>  getStatisticsPropertyAddSold(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException {
        PersistentSession session = getSession();
        Map<String, Map.Entry<Long,Long>> data = new HashMap<>();

        System.out.println(dateBegin);
        System.out.println(dateEnd);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
        Date dateB = formatter.parse(dateBegin);
        Date dateE = formatter.parse(dateEnd);
        System.out.println(dateB);
        System.out.println(dateE);

        Criteria crit = session.createCriteria(Property.class, "P")
                .add(Restrictions.between("publishDate", dateB, dateE))
                .createAlias("P.owner", "u")
                .add(Restrictions.eq("u.ID", ID))
               // .add(Restrictions.eq("sold", Boolean.TRUE))
                .setProjection(Projections.projectionList()
                        .add(Projections.sqlGroupProjection("TO_CHAR(publishDate, 'MM') as month","month", new String[]{"month"},new Type[]{new StringType()}))
                        //.add(Projections.property("monthDate"))
                        .add(Projections.rowCount()));
                        //.add(Projections.sqlGroupProjection("{alias} month")));
                //.addOrder(Order.desc("monthDate"));

        Criteria crit2 = session.createCriteria(Property.class, "P")
                .add(Restrictions.between("publishDate", dateB, dateE))
                .createAlias("P.owner", "u")
                .add(Restrictions.eq("u.ID", ID))
                .add(Restrictions.eq("sold", Boolean.TRUE))
                .setProjection(Projections.projectionList()
                        .add(Projections.sqlGroupProjection("TO_CHAR(publishDate, 'MM') as month","month", new String[]{"month"},new Type[]{new StringType()}))
                        //.add(Projections.property("monthDate"))
                        .add(Projections.rowCount()));
        //.add(Projections.sqlGroupProjection("{alias} month")));
        //.addOrder(Order.desc("monthDate"));

        System.out.println("Done");
        List allResults = crit.list();
        List soldResults = crit2.list();
        System.out.println(allResults);
        for (Iterator iter = allResults.iterator(); iter.hasNext();)
        {
            Object object[] = (Object[]) iter.next();
            System.out.println(object[0]);
            System.out.println(object[1]);
            //Map.Entry<Long, Long> pair = new AbstractMap.SimpleEntry<>((Long)object[1],(Long) object[1]);
            Map.Entry<Long, Long> pair = new AbstractMap.SimpleEntry<>((Long)object[1], 0L);
            data.put((String) object[0],pair);


        }
        System.out.println(data);
        System.out.println(data.size());
        System.out.println(soldResults);
        for (Iterator iter = soldResults.iterator(); iter.hasNext();)
        {
            Object object[] = (Object[]) iter.next();
            System.out.println(object[0]);
            System.out.println(object[1]);
            String month = (String) object[0];
            if (data.containsKey(month)) {
                Map.Entry<Long, Long> pair = data.get(month);
                pair.setValue((Long) object[1]);
                data.replace(month, pair);
            }
        }
        System.out.println(data);
        System.out.println(data.size());

        return data;
    }

    public Map<Date, Long> getStatisticsQuantity(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException {
        PersistentSession session = getSession();
        Map<Date,Long> data = new HashMap<>();

        System.out.println(dateBegin);
        System.out.println(dateEnd);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
        Date dateB = formatter.parse(dateBegin);
        Date dateE = formatter.parse(dateEnd);
        System.out.println(dateB);
        System.out.println(dateE);

        Criteria crit = session.createCriteria(Property.class, "P")
                .add(Restrictions.between("publishDate", dateB, dateE))
                .createAlias("P.owner", "u")
                .add(Restrictions.eq("u.ID", ID))
                .add(Restrictions.eq("sold", Boolean.TRUE))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("publishDate"))
                        .add(Projections.rowCount())
                        .add(Projections.groupProperty("publishDate")))
                .addOrder(Order.desc("publishDate"));

        System.out.println("Done");
        List results = crit.list();
        System.out.println(results);

        for (Iterator iter = results.iterator(); iter.hasNext();)
        {
            Object object[] = (Object[]) iter.next();
            System.out.println(object[0]);
            System.out.println(object[1]);
            data.put((Date)object[0],(Long) object[1]);

        }
        System.out.println(data);
        System.out.println(data.size());
        return data;
    }

    public List<Map<String,Object>> getComplaints() throws PersistentException{
        PersistentSession session = getSession();

        Query query = session.createSQLQuery("select p.ID, p.Name, c.Description, p.usersID from Property as p, Complaint as c where p.ID = c.propertyID AND p.blocked = false");
        List<Object[]> queryResult = query.list();
        System.out.println(queryResult);

        Map<Integer, Map<String,Object>> complaints = new HashMap<>();

        for (Object[] comp: queryResult){
            Integer id = (Integer) comp[0];
            String name = (String) comp[1];
            String description = (String) comp[2];
            Integer owner = (Integer) comp[3];

            if (complaints.containsKey(id)){
                List complaintsValues = (List) complaints.get(id).get("complaints");
                complaintsValues.add(description);
            }
            else{
                Map<String, Object> aux = new HashMap<>();
                aux.put("id",id);
                aux.put("name",name);
                aux.put("owner", owner);
                List complaints_aux = new ArrayList<>();
                complaints_aux.add(description);
                aux.put("complaints", complaints_aux);
                complaints.put(id, aux);
            }
        }
        return new ArrayList<>(complaints.values());
    }

    public boolean blockUser(int ID) throws PersistentException{
        PersistentSession session = getSession();
        Common userInfo = CommonDAO.getCommonByORMID(session,ID);
        if (userInfo!= null) {
            userInfo.setBlocked(true);
            session.save(userInfo);
            Property[] userProperties = PropertyDAO.listPropertyByQuery(session, "usersId=" + userInfo.getID(), null);
            System.out.println(userProperties);
            for (Property p : userProperties) {
                p.setBlocked(true);
                session.save(p);
            }
            return true;
        }
        else
            return false;
    }

    public boolean isBlocked(int ID) throws PersistentException{
        PersistentSession session = getSession();
        Common userInfo = CommonDAO.getCommonByORMID(session,ID);
        if (userInfo!= null){
            return userInfo.getBlocked();
        }
        else{
            return true;
        }
    }

    public Complaint insertComplaint(String description, String propertyID) throws PersistentException{
        PersistentSession session = getSession();
        PersistentTransaction t = session.beginTransaction();
        try {
            Complaint complaint = ComplaintDAO.createComplaint();
            complaint.setDescription(description);
            Property property = PropertyDAO.getPropertyByORMID(session, Integer.parseInt(propertyID));
            property.complaints.add(complaint);
            session.save(property);
            session.save(complaint);
            t.commit();
            return complaint;
        }
        catch (Exception e) {
            t.rollback();
            throw e;
        }
    }
}
