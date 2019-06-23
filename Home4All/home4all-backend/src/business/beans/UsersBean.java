package business.beans;

import business.Utils;
import business.entities.*;
import business.exceptions.*;
import data.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
                genderValue = GenderDAO.loadGenderByORMID(gender);
                if (genderValue == null)
                    throw new GenderNotExistentException();
            } else {
                genderValue = null;
            }
            Occupation occupationValue;
            if (occupation != null) {
                occupationValue = OccupationDAO.loadOccupationByORMID(occupation);
                if (occupationValue == null)
                    throw new OccupationNotExistentException();
            } else {
                occupationValue = null;
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
            CommonDAO.save(user);
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
                genderValue = GenderDAO.loadGenderByORMID(gender);
                user.setGender(genderValue);
                if (genderValue == null)
                    throw new GenderNotExistentException();
            }

            Occupation occupationValue;
            if (occupation != null) {
                occupationValue = OccupationDAO.loadOccupationByORMID(occupation);
                user.setOccupation(occupationValue);
                if (occupationValue == null)
                    throw new OccupationNotExistentException();
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
            CommonDAO.save(user);
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

    public Map<Date,Integer>  getStatistics(int ID, String dateBegin, String dateEnd) throws PersistentException{
        PersistentSession session = getSession();
        Map<Date,Integer> data = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dateB = LocalDate.parse(dateBegin, formatter);
        LocalDate dateE = LocalDate.parse(dateEnd, formatter);
        //String condition = ""
        //PropertyDAO.queryProperty(session,)
        return data;
    }
}
