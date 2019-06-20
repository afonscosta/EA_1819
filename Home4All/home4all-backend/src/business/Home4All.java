package business;

import business.beans.PropertyBeanLocal;
import business.beans.UsersBeanLocal;
import business.entities.*;
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

    public static Common insertCommonUser(String email, String name, String password, int age, String phone,
                                          Gender gender, Occupation occupation) throws PersistentException {
        return usersBean.insertCommonUser(email, name, password, age, phone, gender, occupation);
    }

    public static Property registerSharedProperty(
                String name, List<byte[]> photos, String description, String type, String typology,
                float area, String district, String city, String street,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int females, int males,
                int smokers, int petsQuantity, List<String> pets, List<String> occupations,
                boolean totalAccess, List<Map<String, Object>> bedrooms)
            throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException {

        return propertyBean.registerSharedProperty(
                name, photos, description, type, typology, area, district, city, street, expensesIncluded,
                equipmentIncluded, allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets, allowedOccupations,
                allowedGenders, females, males, smokers, petsQuantity, pets, occupations, totalAccess, bedrooms);
    }

    public static Property registerPrivateProperty(
                String name, List<byte[]> photos, String description, String type, String typology,
                float area, String district, String city, String street,
                boolean furnished, Date availability, boolean rent, boolean sell, float rentPrice, float sellPrice,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders)
            throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException {

        return propertyBean.registerPrivateProperty(
                name, photos, description, type, typology, area, district, city, street, furnished,availability,
                rent, sell, rentPrice, sellPrice, expensesIncluded, equipmentIncluded, allowedMinAge, allowedMaxAge,
                allowedSmokers, allowedPets, allowedOccupations, allowedGenders
        );
    }
}