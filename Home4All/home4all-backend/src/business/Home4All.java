package business;

import business.beans.PropertyBeanLocal;
import business.beans.UsersBeanLocal;
import business.entities.Common;
import business.entities.Property;
import business.entities.Users;
import business.exceptions.*;
import org.orm.PersistentException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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


    public static List<Users> listUsers() throws PersistentException {
        return usersBean.listUsers();
    }

    public static Common insertCommonUser(String email, String name, String password, int age, String phone) throws PersistentException {
        return usersBean.insertCommonUser(email, name, password, age, phone);
    }

    public static Property registerSharedProperty(
                String name, List<String> photos, String description, String type, String typology,
                float area, String district, String city, String street, float lat, float lng,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int females, int males,
                int smokers, int petsQuantity, List<String> pets, List<String> occupations,
                boolean totalAccess, List<Map<String, Object>> bedrooms, int ownerId)
            throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException,
            BedroomTypeNotExistentException {

        return propertyBean.registerSharedProperty(
                name, photos, description, type, typology, area, district, city, street, lat, lng, expensesIncluded,
                equipmentIncluded, allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets, allowedOccupations,
                allowedGenders, females, males, smokers, petsQuantity, pets, occupations, totalAccess, bedrooms, ownerId);
    }

    public static Property registerPrivateProperty(
                String name, List<String> photos, String description, String type, String typology,
                float area, String district, String city, String street, float lat, float lng,
                boolean furnished, Date availability, boolean rent, boolean sell, float rentPrice, float sellPrice,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int ownerId)
            throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException {

        return propertyBean.registerPrivateProperty(
                name, photos, description, type, typology, area, district, city, street, lat, lng, furnished,
                availability, rent, sell, rentPrice, sellPrice, expensesIncluded, equipmentIncluded,
                allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets, allowedOccupations, allowedGenders, ownerId
        );
    }

    public static String nextImageName(String originalName, String format) throws PersistentException {
        return propertyBean.nextImageName(originalName, format);
    }
}