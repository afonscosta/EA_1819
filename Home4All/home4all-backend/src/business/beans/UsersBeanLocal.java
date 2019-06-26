package business.beans;

import business.entities.Common;
import business.entities.Complaint;
import business.entities.Users;
import business.exceptions.GenderNotExistentException;
import business.exceptions.OccupationNotExistentException;
import org.orm.PersistentException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface UsersBeanLocal {
    List<Users> listUsers() throws PersistentException;

    Common insertCommonUser(String email, String name, String password, String birthdate, String phone, String gender,
                           String occupation) throws PersistentException, GenderNotExistentException, OccupationNotExistentException, ParseException;

    Common updateCommonUser(int id, String name, String password, String birthdate, String phone, String gender,
                           String occupation) throws PersistentException, GenderNotExistentException, OccupationNotExistentException, ParseException;

    Users login(String email, String password) throws PersistentException;

    Common getUser(int ID) throws PersistentException;

    Map<String, Map.Entry<Long, Long>> getStatisticsPropertyAddSold(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException;

    Map<Date, Long> getStatisticsQuantity(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException;

    List<Map<String,Object>> getComplaints() throws PersistentException;

    boolean blockUser(int ID) throws PersistentException;

    boolean isBlocked(int ID) throws PersistentException;

    Complaint insertComplaint(String description, String propertyID) throws PersistentException;

    Users getUserbyUsers(int ID) throws PersistentException;

}
