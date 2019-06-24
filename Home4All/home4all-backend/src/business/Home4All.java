package business;

import business.beans.PropertyBeanLocal;
import business.beans.UsersBeanLocal;
import business.entities.*;
import business.exceptions.*;
import javafx.util.Pair;
import org.orm.PersistentException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Home4All {
    private static UsersBeanLocal usersBean = lookupUsersBeanLocal();
    private static PropertyBeanLocal propertyBean = lookupPropertyBeanLocal();

    private static UsersBeanLocal lookupUsersBeanLocal() {
        try {

            Context c = new InitialContext();
            return (UsersBeanLocal) c.lookup("java:global/Home4All/UsersEJB!business.beans.UsersBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    private static PropertyBeanLocal lookupPropertyBeanLocal() {
        try {

            Context c = new InitialContext();
            return (PropertyBeanLocal) c.lookup("java:global/Home4All/PropertyEJB!business.beans.PropertyBeanLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    public static Users login(String email, String password) throws PersistentException{
        return usersBean.login(email,password);
    }


    public static List<Users> listUsers() throws PersistentException {
        return usersBean.listUsers();
    }

    public static Common insertCommonUser(String email, String name, String password, String birthdate, String phone,
                                          String gender, String occupation)
            throws PersistentException, GenderNotExistentException, OccupationNotExistentException, ParseException {
        return usersBean.insertCommonUser(email, name, password, birthdate, phone, gender, occupation);
    }

    public static Common updateCommonUser(int id, String name, String password, String birthdate, String phone,
                                          String gender, String occupation)
            throws PersistentException, GenderNotExistentException, OccupationNotExistentException, ParseException {
        return usersBean.updateCommonUser(id, name, password, birthdate, phone, gender, occupation);
    }


    public static Common getUser(int ID) throws PersistentException {
        return usersBean.getUser(ID);
    }

    public static Map<String, Map.Entry<Long,Long>> getStatisticsPropertyAddSold(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException {
        return usersBean.getStatisticsPropertyAddSold(ID, dateBegin, dateEnd);
    }

    public static Map<Date,Long> getStatisticsQuantity(int ID, String dateBegin, String dateEnd) throws PersistentException, ParseException {
        return usersBean.getStatisticsQuantity(ID, dateBegin, dateEnd);
    }

    public static List<Map<String,Object>> getComplaints() throws PersistentException{
        return usersBean.getComplaints();
    }

    public static void blockUser(Integer userId)  throws PersistentException{
        usersBean.blockUser(userId);
    }

    public static Property registerSharedProperty(
                Integer id,  String name, List<String> photos, String description, String typology,
                float area, String district, String city, String street, float lat, float lng,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int females, int males,
                int smokers, int petsQuantity, List<String> pets, List<String> occupations,
                boolean totalAccess, List<Map<String, Object>> bedrooms, int ownerId)
            throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException,
            BedroomTypeNotExistentException, PropertyNotExistentException, IOException {

        return propertyBean.registerSharedProperty(
                id, name, photos, description, typology, area, district, city, street, lat, lng, expensesIncluded,
                equipmentIncluded, allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets, allowedOccupations,
                allowedGenders, females, males, smokers, petsQuantity, pets, occupations, totalAccess, bedrooms, ownerId);
    }

    public static Property registerPrivateProperty(
                Integer id, String name, List<String> photos, String description, String type, String typology,
                float area, String district, String city, String street, float lat, float lng,
                boolean furnished, Date availability, boolean rent, boolean sell, Float rentPrice, Float sellPrice,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int ownerId)
            throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException,
            PropertyNotExistentException, IOException {

        return propertyBean.registerPrivateProperty(
                id, name, photos, description, type, typology, area, district, city, street, lat, lng, furnished,
                availability, rent, sell, rentPrice, sellPrice, expensesIncluded, equipmentIncluded,
                allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets, allowedOccupations, allowedGenders, ownerId
        );
    }

    public static Property getProperty(int ID) throws PersistentException {
        return propertyBean.getProperty(ID);
    }

    public static boolean deleteProperty(int ID) throws PersistentException {
        return propertyBean.deleteProperty(ID);
    }

    public static List<Property> searchProperties(String district, String city, String completeAddress,
                int page, int propsPerPage, int numberOfPages,
                // Filters
                List<String> types, List<String> typologies, boolean sell, boolean rent,
                Float minSellPrice, Float maxSellPrice, Float minRentPrice, Float maxRentPrice,
                Integer peopleQuantity, List<String> bedroomsTypes, Integer peopleAmountMultiple,
                boolean privateWC, boolean sharedWC, List<String> hasOccupations, boolean hasPets,
                boolean notPets, boolean hasSmokers, boolean notSmokers, boolean furnished,
                boolean notFurnished, boolean totalAccess, boolean notTotalAccess,
                // Ordination
                String ordination,
                // User Information
                Gender userGender, Occupation userOccupation, Integer userAge)
            throws PersistentException, OrdinationNotExistentException {
        return propertyBean.searchProperties(district, city, completeAddress, page, propsPerPage, numberOfPages,
                types, typologies, sell, rent, minSellPrice, maxSellPrice, minRentPrice, maxRentPrice,
                peopleQuantity, bedroomsTypes, peopleAmountMultiple, privateWC, sharedWC, hasOccupations, hasPets, notPets,
                hasSmokers, notSmokers, furnished, notFurnished, totalAccess, notTotalAccess, ordination,
                userGender, userOccupation, userAge);
    }
}