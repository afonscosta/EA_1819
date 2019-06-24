package business.beans;

import business.entities.Common;
import business.entities.Users;
import business.exceptions.GenderNotExistentException;
import business.exceptions.OccupationNotExistentException;
import org.orm.PersistentException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface UsersBeanLocal {
    public List<Users> listUsers() throws PersistentException;

    public Common insertCommonUser(String email, String name, String password, String birthdate, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException, OccupationNotExistentException, ParseException;

    public Common updateCommonUser(int id, String name, String password, String birthdate, String phone, String gender,
                                   String occupation) throws PersistentException, GenderNotExistentException, OccupationNotExistentException, ParseException;

    public Users login(String email, String password) throws PersistentException;

    public Common getUser(int ID) throws PersistentException;

    public Map<String, Map.Entry<Long, Long>> getStatisticsPropertyAddSold(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException;

    public Map<Date, Long> getStatisticsQuantity(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException;

    public List<Map<String,Object>> getComplaints() throws PersistentException;

    public void blockUser(int ID) throws PersistentException;

}
