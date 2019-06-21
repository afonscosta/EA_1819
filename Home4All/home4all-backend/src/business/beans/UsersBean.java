package business.beans;

import business.Utils;
import business.entities.*;
import business.exceptions.*;
import data.*;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Stateless(name = "UsersEJB")
public class UsersBean implements UsersBeanLocal {
    public UsersBean() {
    }

    @Override
    public Users login(String email, String password) throws PersistentException {
        return UsersDAO.loadUsersByQuery("email='"+email+"' AND password='"+ Utils.hash(password)+"'", null);
    }

    @Override
    public List<Users> listUsers() throws PersistentException {
        Users[] users = data.UsersDAO.listUsersByQuery(null, null);
        return new ArrayList<>(Arrays.asList(users));
    }

    @Override
    public Common insertCommonUser(String email, String name, String password, String age, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException,
                                                             OccupationNotExistentException {
        Common user;
        if (password != null) {
            user = InternalAccountDAO.createInternalAccount();
            ((InternalAccount) user).setPassword(Utils.hash(password));
        }
        else {
            user = CommonDAO.createCommon();
        }
        Gender genderValue;
        if (gender!=null) {
            genderValue = GenderDAO.loadGenderByORMID(gender);
            if (genderValue == null)
                throw new GenderNotExistentException();
        }
        else {
            genderValue = null;
        }
        Occupation occupationValue;
        if (occupation!=null) {
            occupationValue = OccupationDAO.loadOccupationByORMID(occupation);
            if (occupationValue == null)
                throw new OccupationNotExistentException();
        }
        else {
            occupationValue = null;
        }
        System.out.println(genderValue);
        System.out.println(occupationValue);
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        user.setAge(Integer.parseInt(age));
        user.setGender(genderValue);
        user.setOccupation(occupationValue);
        user.setLastLogin(new Date());
        CommonDAO.save(user);
        return CommonDAO.loadCommonByQuery("email = '" + email + "'", null);
    }

}
