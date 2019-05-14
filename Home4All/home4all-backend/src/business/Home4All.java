package business;

import business.entities.Common;
import business.entities.Users;
import business.beans.UsersBeanLocal;
import org.orm.PersistentException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class Home4All {
    private static UsersBeanLocal usersBean = lookupUsersBeanLocal();

    private static UsersBeanLocal lookupUsersBeanLocal() {
        try {

            Context c = new InitialContext();
            return (UsersBeanLocal) c.lookup("java:global/Home4All/UsersEJB!business.beans.UsersBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }


    public static List<Users> listUsers() throws PersistentException {
        return usersBean.listUsers();
    }

    public static Common insertCommonUser(String email, String name, String password, int age, String phone) throws PersistentException {
        return usersBean.insertCommonUser(email, name, password, age, phone);
    }
}
