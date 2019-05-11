package business.beans;

import PSM.Users;
import org.orm.PersistentException;

import java.util.List;

public interface UsersBeanLocal {
    public List<Users> listUsers() throws PersistentException;
    public Users insertCommonUser(String email, String name, String password, int age, String phone) throws PersistentException;
}
