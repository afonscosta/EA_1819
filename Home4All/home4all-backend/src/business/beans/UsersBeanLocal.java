package business.beans;

import business.entities.Common;
import business.entities.Gender;
import business.entities.Occupation;
import business.entities.Users;
import business.exceptions.GenderNotExistentException;
import business.exceptions.OccupationNotExistentException;
import org.orm.PersistentException;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface UsersBeanLocal {
    public List<Users> listUsers() throws PersistentException;
    public Common insertCommonUser(String email, String name, String password, String age, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException, OccupationNotExistentException;
    public Common updateCommonUser(int id, String name, String password, String age, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException, OccupationNotExistentException;

    public Users login(String email, String password) throws PersistentException;
    public Common getUser(int ID) throws PersistentException;
    public Map<Date,Integer> getStatistics(int ID, String dateBegin, String dateEnd) throws PersistentException;

}
