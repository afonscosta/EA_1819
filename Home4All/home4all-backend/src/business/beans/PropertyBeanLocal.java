package business.beans;

import business.entities.*;
import business.exceptions.*;
import org.orm.PersistentException;

import java.io.IOException;
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
            PropertyNotExistentException, IOException;
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
            MissingPropertiesException, BedroomTypeNotExistentException, PropertyNotExistentException, IOException;

    Property getProperty(int ID) throws PersistentException;

    boolean deleteProperty(int ID) throws PersistentException;

    List<Property> searchProperties(String district, String city, String completeAddress,
                int page, int propsPerPage, int numberOfPages,
                // Filters
                List<String> types, List<String> typologies,
                boolean sell, boolean rent,
                Float minSellPrice, Float maxSellPrice, Float minRentPrice, Float maxRentPrice,
                Integer peopleQuantity, List<String> bedroomsTypes, Integer peopleAmountMultiple,
                boolean privateWC, boolean sharedWC, List<String> hasOccupations, boolean hasPets,
                boolean notPets, boolean hasSmokers, boolean notSmokers, boolean furnished,
                boolean notFurnished, boolean totalAccess, boolean notTotalAcess,
                // Ordination
                String ordination,
                // User Information
                Gender userGender, Occupation userOccupation, Integer userAge)
            throws PersistentException, OrdinationNotExistentException;
}
