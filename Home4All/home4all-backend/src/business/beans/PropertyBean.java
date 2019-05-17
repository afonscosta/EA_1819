package business.beans;

import business.entities.*;
import business.exceptions.*;
import data.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless(name = "PropertyEJB")
public class PropertyBean implements PropertyBeanLocal{
    private static PersistentSession session = null;

    public PropertyBean() {
    }

    private PersistentSession getSession() {
        if (session == null) {
            try {
                session = Home4AllPersistentManager.instance().getSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return session;
    }

    private void changeProperty(Property property,
                String name, List<byte[]> photos, String description, String typology,
                float area, String district, String city, String street,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders)
            throws PersistentException, TypologyNotExistentException, GenderNotExistentException,
            OccupationNotExistentException, EquipmentNotExistentException, ExpenseNotExistentException {

        property.setName(name);
        property.setDescription(description);

        Typology t = TypologyDAO.loadTypologyByORMID(typology);
        if (t == null)
            throw new TypologyNotExistentException();
        property.setTypology(t);

        property.setArea(area);
        property.setDistrict(district);
        property.setCity(city);
        property.setStreet(street);

        property.expensesIncluded.clear();
        for (String expenseName: expensesIncluded) {
            Expenses expense = ExpensesDAO.loadExpensesByORMID(expenseName);
            if (expense == null)
                throw new ExpenseNotExistentException();
            property.expensesIncluded.add(expense);
        }

        property.equipmentIncluded.clear();
        for (String equipmentName: equipmentIncluded) {
            Equipment equipment = EquipmentDAO.loadEquipmentByORMID(equipmentName);
            if (equipment == null)
                throw new EquipmentNotExistentException();
            property.equipmentIncluded.add(equipment);
        }

        property.setAllowedMinAge(allowedMinAge);
        property.setAllowedMaxAge(allowedMaxAge);
        property.setAllowedSmoker(allowedSmokers);
        property.setAllowedPets(allowedPets);

        property.allowedOccupations.clear();
        for (String occupationName: allowedOccupations) {
            Occupation occupation = OccupationDAO.loadOccupationByORMID(occupationName);
            if (occupation == null)
                throw new OccupationNotExistentException();
            property.allowedOccupations.add(occupation);
        }

        Gender gender = GenderDAO.loadGenderByORMID(allowedGenders);
        if (gender == null) {
            throw new GenderNotExistentException();
        }
        property.setAllowedGenders(gender);

        property.setPublishDate(new Date());

        // TODO: Photos
        // TODO: Dúvida - variável session no PropertyBean Stateless
    }


    @Override
    public Property registerPrivateProperty(
                String name, List<byte[]> photos, String description, String type, String typology,
                float area, String district, String city, String street,
                boolean furnished, Date availability, boolean rent, boolean sell, float rentPrice, float sellPrice,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders)
            throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException {

        Private property;

        System.out.println("1");

        if (type.equals("villa"))
            property = VillaDAO.createVilla();
        else
            property = ApartmentDAO.createApartment();
        System.out.println("2");

        changeProperty(property, name, photos, description, typology, area,
                district, city, street, expensesIncluded, equipmentIncluded,
                allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets,
                allowedOccupations, allowedGenders);

        System.out.println("3");

        property.setFurnished(furnished);
        property.setAvailability(availability);
        if (rent)
            property.setRentPrice(rentPrice);
        if (sell)
            property.setSellPrice(sellPrice);
        property.setSold(false);
        System.out.println("4");

        PrivateDAO.save(property);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        System.out.println("5");

        return PropertyDAO.loadPropertyByQuery("name = :name", null, parameters);
    }

    @Override
    public Property registerSharedProperty(
                String name, List<byte[]> photos, String description, String type, String typology,
                float area, String district, String city, String street,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int females, int males,
                int smokers, int petsQuantity, List<String> pets, List<String> occupations,
                boolean totalAccess, List<Map<String, Object>> bedrooms)
            throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException {

        PersistentSession s = getSession();
        PersistentTransaction t = s.beginTransaction();
        try {
            Shared property = SharedDAO.createShared();

            changeProperty(property, name, photos, description, typology, area,
                    district, city, street, expensesIncluded, equipmentIncluded,
                    allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets,
                    allowedOccupations, allowedGenders);

            property.bedrooms.clear();
            for (Map<String, Object> bedroomProps : bedrooms) {
                Bedroom bedroom = BedroomDAO.createBedroom();
                if (bedroomProps.containsKey("furnished")
                        && bedroomProps.containsKey("peopleAmount")
                        && bedroomProps.containsKey("area")
                        && bedroomProps.containsKey("privateBathroom")
                        && bedroomProps.containsKey("availability")
                        && bedroomProps.containsKey("rentPrice")
                        && bedroomProps.containsKey("sold")
                        && bedroomProps.containsKey("photos")) {
                    bedroom.setFurnished((boolean) bedroomProps.get("furnished"));
                    bedroom.setPeopleAmount((int) bedroomProps.get("peopleAmount"));
                    bedroom.setArea((float) bedroomProps.get("area"));
                    bedroom.setPrivateBathroom((boolean) bedroomProps.get("privateBathroom"));
                    bedroom.setAvailability((Date) bedroomProps.get("availability"));
                    bedroom.setRentPrice((float) bedroomProps.get("rentPrice"));
                    bedroom.setSold((boolean) bedroomProps.get("sold"));
                    // TODO: photos
                }
                else {
                    throw new MissingPropertiesException();
                }
                BedroomDAO.save(bedroom);
                property.bedrooms.add(bedroom);
            }

            SharedDAO.save(property);
            t.commit();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            return PropertyDAO.loadPropertyByQuery("name = :name", null, parameters);
        }
        catch (Exception e) {
            t.rollback();
            throw e;
        }
    }
}
