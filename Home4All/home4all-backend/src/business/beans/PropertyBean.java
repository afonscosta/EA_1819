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
                String name, List<String> photos, String description, String typology,
                float area, String district, String city, String street,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int ownerId)
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

        property.photos.clear();
        for (String photoPath: photos) {
            Photo photo = PhotoDAO.createPhoto();
            photo.setPath(photoPath);
            property.photos.add(photo);
        }

        property.setOwner(CommonDAO.getCommonByORMID(ownerId));

        // TODO: Dúvida - variável session no PropertyBean Stateless
    }


    @Override
    public Property registerPrivateProperty(
                String name, List<String> photos, String description, String type, String typology,
                float area, String district, String city, String street,
                boolean furnished, Date availability, boolean rent, boolean sell, float rentPrice, float sellPrice,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int ownerId)
            throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException {

        Private property;

        if (type.equals("villa"))
            property = VillaDAO.createVilla();
        else
            property = ApartmentDAO.createApartment();

        changeProperty(property, name, photos, description, typology, area,
                district, city, street, expensesIncluded, equipmentIncluded,
                allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets,
                allowedOccupations, allowedGenders, ownerId);

        property.setFurnished(furnished);
        property.setAvailability(availability);
        if (rent)
            property.setRentPrice(rentPrice);
        if (sell)
            property.setSellPrice(sellPrice);
        property.setSold(false);

        PrivateDAO.save(property);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);

        return PropertyDAO.loadPropertyByQuery("name = :name", null, parameters);
    }

    @Override
    public Property registerSharedProperty(
                String name, List<String> photos, String description, String type, String typology,
                float area, String district, String city, String street,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                int allowedMinAge, int allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int females, int males,
                int smokers, int petsQuantity, List<String> pets, List<String> occupations,
                boolean totalAccess, List<Map<String, Object>> bedrooms, int ownerId)
            throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException,
            BedroomTypeNotExistentException {

        PersistentSession s = getSession();
        PersistentTransaction t = s.beginTransaction();
        try {
            Shared property = SharedDAO.createShared();

            changeProperty(property, name, photos, description, typology, area,
                    district, city, street, expensesIncluded, equipmentIncluded,
                    allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets,
                    allowedOccupations, allowedGenders, ownerId);

            property.bedrooms.clear();

            SharedDAO.save(property);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            property = (Shared) PropertyDAO.loadPropertyByQuery("name = :name", null, parameters);

            if (property != null) {
                for (Map<String, Object> bedroomProps : bedrooms) {
                    Bedroom bedroom = BedroomDAO.createBedroom();
                    if (bedroomProps.containsKey("type")
                            && bedroomProps.containsKey("furnished")
                            && bedroomProps.containsKey("peopleAmount")
                            && bedroomProps.containsKey("area")
                            && bedroomProps.containsKey("privateBathroom")
                            && bedroomProps.containsKey("availability")
                            && bedroomProps.containsKey("rentPrice")
                            && bedroomProps.containsKey("images")) {

                        String bType = (String) bedroomProps.get("type");

                        if (bType.equals("single"))
                            bedroom.setPeopleAmount(1);
                        else if (bType.equals("double"))
                            bedroom.setPeopleAmount(2);
                        else if (bType.equals("multiple"))
                            bedroom.setPeopleAmount(Integer.parseInt((String) bedroomProps.get("peopleAmount")));
                        else
                            throw new BedroomTypeNotExistentException();

                        BedroomType bedroomType = BedroomTypeDAO.getBedroomTypeByORMID(bType);
                        bedroom.setType(bedroomType);

                        bedroom.setFurnished((boolean) bedroomProps.get("furnished"));
                        bedroom.setArea(Float.parseFloat((String) bedroomProps.get("area")));
                        bedroom.setPrivateBathroom((boolean) bedroomProps.get("privateBathroom"));
                        bedroom.setAvailability((Date) bedroomProps.get("availability"));
                        bedroom.setRentPrice(Float.parseFloat((String) bedroomProps.get("rentPrice")));
                        bedroom.setSold(false);
                        bedroom.photos.clear();
                        for (String photoPath : (List<String>) bedroomProps.get("images")) {
                            Photo photo = PhotoDAO.createPhoto();
                            photo.setPath(photoPath);
                            property.photos.add(photo);
                        }
                    } else {
                        throw new MissingPropertiesException();
                    }
                    BedroomDAO.save(bedroom);
                    property.bedrooms.add(bedroom);
                }

                SharedDAO.save(property);
                t.commit();
            }
            else {
                t.rollback();
            }

            return property;
        }
        catch (Exception e) {
            t.rollback();
            throw e;
        }
    }

    public String nextImageName(String originalName) throws PersistentException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("path", originalName);
        Photo photo = PhotoDAO.loadPhotoByQuery("path LIKE '^:path(\\_\\d+)?.[^.]+$'", "id DESC");
        if (photo == null) {
            return originalName;
        }
        else {
            String suffix = photo.getPath().replace(originalName, "").replace("_", "");
            suffix = suffix.substring(0, suffix.lastIndexOf('.'));
            int suffix_int = (suffix.isEmpty() ? 0 : Integer.parseInt(suffix)) + 1;
            return String.format("%s_%d", originalName, suffix_int);
        }
    }
}
