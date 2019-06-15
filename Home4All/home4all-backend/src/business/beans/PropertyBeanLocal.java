package business.beans;

import business.entities.Property;
import business.exceptions.*;
import org.orm.PersistentException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PropertyBeanLocal {
    Property registerPrivateProperty(
            String name, List<String> photos, String description, String type, String typology,
            float area, String district, String city, String street,
            boolean furnished, Date availability, boolean rent, boolean sell, float rentPrice, float sellPrice,
            List<String> expensesIncluded, List<String> equipmentIncluded,
            int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
            List<String> allowedOccupations, String allowedGenders, int ownerId
    ) throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException;
    Property registerSharedProperty(
            String name, List<String> photos, String description, String type, String typology,
            float area, String district, String city, String street,
            List<String> expensesIncluded, List<String> equipmentIncluded,
            int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
            List<String> allowedOccupations, String allowedGenders,
            int females, int males, int smokers, int petsQuantity, List<String> pets,
            List<String> occupations, boolean totalAccess, List<Map<String, Object>> bedrooms, int ownerId
    ) throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException, BedroomTypeNotExistentException;

    public String nextImageName(String originalName) throws PersistentException;
}
