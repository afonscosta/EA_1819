package business.beans;

import business.entities.Common;
import business.entities.InternalAccount;
import business.entities.Users;
import data.*;
import org.orm.PersistentException;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
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
    public Common insertCommonUser(String email, String name, String password, int age, String phone) throws PersistentException {
        Common user;
        if (password != null) {
            user = InternalAccountDAO.createInternalAccount();
            ((InternalAccount) user).setPassword(password);
        }
        else {
            user = CommonDAO.createCommon();
        }

        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        user.setAge(age);
        user.setGender(null);
        user.setOccupation(null);
        user.setLastLogin(null);
        CommonDAO.save(user);
        System.out.println(user);
        return CommonDAO.loadCommonByQuery("email = '" + email + "'", null);
    }

}
