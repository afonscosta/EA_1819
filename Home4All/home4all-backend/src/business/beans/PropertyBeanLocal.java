package business.beans;

import business.entities.Property;
import business.exceptions.*;
import org.orm.PersistentException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PropertyBeanLocal {
    Property registerPrivateProperty(
            Integer ID, String name, List<String> photos, String description, String type, String typology,
            float area, String district, String city, String completeAddress, float lat, float lng,
            boolean furnished, Date availability, boolean rent, boolean sell, Float rentPrice, Float sellPrice,
            List<String> expensesIncluded, List<String> equipmentIncluded,
            Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
            List<String> allowedOccupations, String allowedGenders, int ownerId
    ) throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException,
            PropertyNotExistentException;
    Property registerSharedProperty(
            Integer ID, String name, List<String> photos, String description, String typology,
            float area, String district, String city, String completeAddress, float lat, float lng,
            List<String> expensesIncluded, List<String> equipmentIncluded,
            Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
            List<String> allowedOccupations, String allowedGenders,
            int females, int males, int smokers, int petsQuantity, List<String> pets,
            List<String> occupations, boolean totalAccess, List<Map<String, Object>> bedrooms, int ownerId
    ) throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException,
            MissingPropertiesException, BedroomTypeNotExistentException, PropertyNotExistentException;

    String nextImageName(String originalName, String format) throws PersistentException;

    Property getProperty(int ID) throws PersistentException;

    boolean deleteProperty(int ID) throws PersistentException;
}
