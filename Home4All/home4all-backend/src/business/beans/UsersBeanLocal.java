package business.beans;

import business.entities.Common;
import business.entities.Users;
import org.orm.PersistentException;

import java.util.List;

public interface UsersBeanLocal {
    public List<Users> listUsers() throws PersistentException;
    public Common insertCommonUser(String email, String name, String password, int age, String phone) throws PersistentException;
}
