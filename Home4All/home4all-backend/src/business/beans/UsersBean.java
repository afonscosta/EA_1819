package business.beans;

import business.entities.*;
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
    public List<Users> listUsers() throws PersistentException {
        Users[] users = data.UsersDAO.listUsersByQuery(null, null);
        return new ArrayList<>(Arrays.asList(users));
    }

    @Override
    public Common insertCommonUser(String email, String name, String password, int age, String phone, Gender gender,
                                   Occupation occupation) throws PersistentException {
        Common user;
        if (password != null) {
            user = InternalAccountDAO.createInternalAccount();
            ((InternalAccount) user).setPassword(password);
        }
        else {
            user = CommonDAO.createCommon();
        }

        //Gender genderValue = GenderDAO.loadGenderByORMID(gender);
        //Occupation occupationValue = OccupationDAO.loadOccupationByORMID(occupation);

        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        user.setAge(age);
        user.setGender(gender);
        user.setOccupation(occupation);
        user.setLastLogin(new Date());
        CommonDAO.save(user);
        System.out.println(user);
        return CommonDAO.loadCommonByQuery("email = '" + email + "'", null);
    }

}
