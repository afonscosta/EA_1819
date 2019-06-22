package business.beans;

import business.entities.*;
import business.exceptions.*;
import data.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

@Stateless(name = "PropertyEJB")
public class PropertyBean implements PropertyBeanLocal {
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


    private String saveNewImage(String image_b64) throws PersistentException, IOException, IOException {
        String[] split = image_b64.split(",");
        String format = split[0].replace("data:image/","")
                                .replace(";base64","");
        image_b64 = split[1];

        // Obter próximo id de path de imagem
        PersistentSession session = getSession();
        BigInteger next_new_path_id = (BigInteger) session
                .createSQLQuery("SELECT nextval('new_image_id')")
                .list().get(0);
        String name = String.format("image_%d.%s", next_new_path_id, format);

        // Criar ficheiro para armazenar a imagem
        File file = new File("images" + File.separator + name);
        file.getParentFile().mkdirs();
        file.createNewFile();

        // Ler e armazenar a imagem
        byte[] image_bytes = Base64.getDecoder().decode(image_b64);
        ByteArrayInputStream bis = new ByteArrayInputStream(image_bytes);
        BufferedImage image = ImageIO.read(bis);
        bis.close();
        ImageIO.write(image, format, file);

        return name;
    }

    private void changeProperty(Property property,
                String name, List<String> photos, String description, String typology,
                float area, String district, String city, String completeAddress, float lat, float lng,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int ownerId)
            throws PersistentException, TypologyNotExistentException, GenderNotExistentException,
            OccupationNotExistentException, EquipmentNotExistentException, ExpenseNotExistentException,
            IOException {

        property.setName(name);
        property.setDescription(description);

        Typology t = TypologyDAO.loadTypologyByORMID(typology);
        if (t == null)
            throw new TypologyNotExistentException();
        property.setTypology(t);

        property.setArea(area);

        Address address = AddressDAO.createAddress();
        address.setDistrict(district);
        address.setCity(city);
        address.setCompleteAddress(completeAddress);
        address.setCoordLat(lat);
        address.setCoordLng(lng);
        property.setAddress(address);

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
        for (String image: photos) {
            Photo photo = PhotoDAO.createPhoto();
            String photoPath = saveNewImage(image);
            photo.setPath(photoPath);
            property.photos.add(photo);
        }

        property.setOwner(CommonDAO.getCommonByORMID(ownerId));
    }


    @Override
    public Property registerPrivateProperty(
                Integer ID, String name, List<String> photos, String description, String type, String typology,
                float area, String district, String city, String completeAddress, float lat, float lng,
                boolean furnished, Date availability, boolean rent, boolean sell, Float rentPrice, Float sellPrice,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int ownerId)
            throws PersistentException, TypologyNotExistentException, ExpenseNotExistentException,
            EquipmentNotExistentException, OccupationNotExistentException, GenderNotExistentException,
            PropertyNotExistentException, IOException {

        Private property;

        if (ID == null) {
            if (type.equals("villa"))
                property = VillaDAO.createVilla();
            else
                property = ApartmentDAO.createApartment();
        }
        else {
            Property p = getProperty(ID);
            if (p instanceof Private)
                property = (Private) p;
            else
                throw new PropertyNotExistentException();
        }

        changeProperty(property, name, photos, description, typology, area,
                district, city, completeAddress, lat, lng, expensesIncluded, equipmentIncluded,
                allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets,
                allowedOccupations, allowedGenders, ownerId);

        property.setFurnished(furnished);
        property.setAvailability(availability);
        if (rent)
            property.setRentPrice(rentPrice);
        else
            property.setRentPrice(null);
        if (sell)
            property.setSellPrice(sellPrice);
        else
            property.setSellPrice(null);

        property.setSold(false);

        PrivateDAO.save(property);

        return property;
    }

    @Override
    public Property registerSharedProperty(
                Integer ID, String name, List<String> photos, String description, String typology,
                float area, String district, String city, String completeAddress, float lat, float lng,
                List<String> expensesIncluded, List<String> equipmentIncluded,
                Integer allowedMinAge, Integer allowedMaxAge, boolean allowedSmokers, boolean allowedPets,
                List<String> allowedOccupations, String allowedGenders, int females, int males,
                int smokers, int petsQuantity, List<String> pets, List<String> occupations,
                boolean totalAccess, List<Map<String, Object>> bedrooms, int ownerId)
            throws TypologyNotExistentException, OccupationNotExistentException, EquipmentNotExistentException,
            ExpenseNotExistentException, PersistentException, GenderNotExistentException, MissingPropertiesException,
            BedroomTypeNotExistentException, PropertyNotExistentException, IOException {

        PersistentSession s = getSession();
        PersistentTransaction t = s.beginTransaction();
        try {
            Shared property;

            if (ID == null) {
                property = SharedDAO.createShared();
            }
            else {
                Property p = getProperty(ID);
                if (p instanceof Shared)
                    property = (Shared) p;
                else
                    throw new PropertyNotExistentException();
            }

            changeProperty(property, name, photos, description, typology, area,
                    district, city, completeAddress, lat, lng, expensesIncluded, equipmentIncluded,
                    allowedMinAge, allowedMaxAge, allowedSmokers, allowedPets,
                    allowedOccupations, allowedGenders, ownerId);

            property.bedrooms.clear();

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
                    bedroom.setArea((float) bedroomProps.get("area"));
                    bedroom.setPrivateBathroom((boolean) bedroomProps.get("privateBathroom"));
                    bedroom.setAvailability((Date) bedroomProps.get("availability"));
                    bedroom.setRentPrice((float) bedroomProps.get("rentPrice"));
                    bedroom.setSold(false);
                    bedroom.photos.clear();
                    for (String image : (List<String>) bedroomProps.get("images")) {
                        Photo photo = PhotoDAO.createPhoto();
                        String photoPath = saveNewImage(image);
                        photo.setPath(photoPath);
                        bedroom.photos.add(photo);
                    }
                } else {
                    throw new MissingPropertiesException();
                }

                property.bedrooms.add(bedroom);
            }

            property.setFemales(females);
            property.setMales(males);
            property.setSmokers(smokers);
            property.setPetsQuantity(petsQuantity);

            property.pets.clear();
            for (String p: pets) {
                Pet pet = new Pet();
                pet.setType(p);
                property.pets.add(pet);
            }

            property.occupations.clear();
            for (String occupationName: occupations) {
                Occupation occupation = OccupationDAO.loadOccupationByORMID(occupationName);
                if (occupation == null)
                    throw new OccupationNotExistentException();
                property.occupations.add(occupation);
            }

            property.setTotalAccess(totalAccess);

            SharedDAO.save(property);
            t.commit();

            return property;
        }
        catch (Exception e) {
            t.rollback();
            throw e;
        }
    }

    public Property getProperty(int ID) throws PersistentException {
        PersistentSession session = getSession();
        return PropertyDAO.getPropertyByORMID(session, ID);
    }

    public boolean deleteProperty(int ID) throws PersistentException {
        PersistentSession session = getSession();
        Property property = PropertyDAO.getPropertyByORMID(session, ID);
        return PropertyDAO.deleteAndDissociate(property, session);
    }

    private String mapOrdinationToOrderBy(String ordination, boolean sharedType, boolean privateType,
                                          boolean sell, boolean rent)
            throws OrdinationNotExistentException, PersistentException {
        String orderBy;
        Ordination ord = OrdinationDAO.getOrdinationByORMID(ordination);
        switch (ord.getName()) {
            case "Price: lowest first":
                if (sharedType && !privateType && !sell && rent)
                    orderBy = "Bedroom.rentPrice ASC";
                else if (!sharedType && privateType && sell && !rent)
                    orderBy = "Property.sellPrice ASC";
                else if (!sharedType && privateType && !sell && rent)
                    orderBy = "Property.rentPrice ASC";
                else if (sharedType && privateType && !sell && rent)
                    orderBy = "LEAST(Bedroom.rentPrice, Property.rentPrice) ASC";
                else
                    orderBy = "Property.id";
                break;
            case "Price: highest first":
                if (sharedType && !privateType && !sell && rent)
                    orderBy = "Bedroom.rentPrice DESC";
                else if (!sharedType && privateType && sell && !rent)
                    orderBy = "Property.sellPrice DESC";
                else if (!sharedType && privateType && !sell && rent)
                    orderBy = "Property.rentPrice DESC";
                else if (sharedType && privateType && !sell && rent)
                    orderBy = "GREATEST(Bedroom.rentPrice, Property.rentPrice) ASC";
                else
                    orderBy = "Property.id";
                break;
            case "Publication Date: newest first":
                orderBy = "publishDate DESC";
                break;
            case "Publication Date: oldest first":
                orderBy = "publishDate ASC";
                break;
            case "Advertiser Login: newest first":
                orderBy = "(SELECT MAX(Users.lastLogin) FROM Users WHERE Users.id = Property.usersId) DESC";
                break;
            case "Advertiser Login: oldest first":
                orderBy = "(SELECT MAX(Users.lastLogin) FROM Users WHERE Users.id = Property.usersId) ASC";
                break;
            default:
                throw new OrdinationNotExistentException();
        }
        return orderBy;
    }

    public List<Property> searchProperties(String district, String city, String completeAddress,
               int page, int propsPerPage, int numberOfPages,
               // Filters
               List<String> types, List<String> typologies, boolean sell, boolean rent,
               Float minSellPrice, Float maxSellPrice, Float minRentPrice, Float maxRentPrice,
               Integer peopleQuantity, List<String> bedroomsTypes, Integer peopleAmountMultiple,
               boolean privateWC, boolean sharedWC, List<String> hasOccupations, boolean hasPets,
               boolean notPets, boolean hasSmokers, boolean notSmokers, boolean furnished,
               boolean notFurnished, boolean totalAccess, boolean notTotalAcess,
               // Ordination
                String ordination,
               // User Information
               Gender userGender, Occupation userOccupation, Integer userAge)
            throws PersistentException, OrdinationNotExistentException {

        // TODO: peopleQuantity
        List<String> tables = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        Map<String, Object> parameters = new HashMap<>();

        // CONDITION BUILDING

        // Location
        if (district != null) {
            parameters.put("district", district);
            conditions.add("Address.district = :district");
        }
        if (city != null) {
            parameters.put("city", city);
            conditions.add("Address.city = :city");
        }
        if (completeAddress != null) {
            parameters.put("completeAddress", completeAddress);
            conditions.add("Address.completeAddress = :completeAddress");
        }

        if (!parameters.isEmpty()) {
            tables.add("Address ON Address.id = Property.addressId");
        }

        // Filters - PropertyType
        if (types!=null && !types.isEmpty()) {
            if (types.contains("Bedrooms")) {
                types.remove("Bedrooms");
                if (rent)
                    types.add("Shared");
            }
            conditions.add("(Property.discriminator = " +
                    String.join(" OR Property.discriminator = ")
                    + ")");
        }

        boolean sharedType = false, privateType = false;
        if (types != null && !types.isEmpty()) {
            if (types.contains("Shared")) {
                tables.add("Bedroom ON Property.id = Bedroom.propertyId");
                sharedType = true;
            }
            if (types.contains("Villa") || types.contains("Apartment")) {
                privateType = true;
            }
        }
        else {
            tables.add("Bedroom ON Property.id = Bedroom.propertyId");
            sharedType = true;
            privateType = true;
        }

        if (privateType && !sharedType) {
            conditions.add("Property.sold = false");
        }
        else if (!privateType && sharedType) {
            conditions.add("Bedroom.sold = false");
        }
        else {
            conditions.add("(Bedroom.sold = false OR Property.sold = false)");
        }

        // Filters - Typologies
        if (typologies!=null && !typologies.isEmpty()) {
            conditions.add("(Property.TypologyName = " +
                    String.join(" OR Property.TypologyName = ", typologies) +
                    ")");
        }

        // Filters - Operation
        if (privateType) {
            if (sell && !rent) {
                conditions.add("(Property.discriminator = 'Shared' OR Property.sellPrice IS NOT NULL)");
            }
            else if (rent && !sell) {
                conditions.add("(Property.discriminator = 'Shared' OR Property.rentPrice IS NOT NULL)");
            }
        }

        // Filters - Price
        if (privateType) {
            if (sell && minSellPrice != null)
                conditions.add("(Property.sellPrice IS NULL OR Property.sellPrice >= " + minSellPrice + ")");
            if (sell && maxSellPrice != null)
                conditions.add("(Property.sellPrice IS NULL OR Property.sellPrice <= " + maxSellPrice + ")");
            if (rent && minRentPrice != null)
                conditions.add("(Property.rentPrice IS NULL OR Property.rentPrice >= " + minRentPrice + ")");
            if (rent && maxRentPrice != null)
                conditions.add("(Property.rentPrice IS NULL OR Property.rentPrice <= " + maxRentPrice + ")");
        }
        if (sharedType) {
            if (minRentPrice != null)
                conditions.add("(Property.discriminator != 'Shared' OR Bedroom.rentPrice >= " + minRentPrice + ")");
            if (maxRentPrice != null)
                conditions.add("(Property.discriminator != 'Shared' OR Bedroom.rentPrice <= " + maxRentPrice + ")");
        }

        if (sharedType) {
            // Filters - BedroomsType
            if (bedroomsTypes!=null && !bedroomsTypes.isEmpty()) {
                String bTypes = "(discriminator != 'Shared' OR Bedroom.bedroomTypeName = " +
                        String.join(" OR Bedroom.bedroomTypeName = ", bedroomsTypes) +
                        ")";
                bTypes = bTypes.replace("Bedroom.bedroomTypeName = multiple",
                        "(Bedroom.bedroomTypeName = multiple " +
                                "AND Bedroom.peopleAmount >= " + peopleAmountMultiple + ")");
                conditions.add(bTypes);
            }

            // Filters - WC
            if (privateWC && !sharedWC) {
                conditions.add("(Property.discriminator != 'Shared' OR Bedroom.privateBathroom = true)");
            }
            else if (sharedWC && !privateWC) {
                conditions.add("(Property.discriminator != 'Shared' OR Bedroom.privateBathroom = false)");
            }

            // Filters - Current Occupations
            if (hasOccupations != null && !hasOccupations.isEmpty()) {
                String occupations = String.join("', '", hasOccupations);
                conditions.add(
                        // <@ significa 'é contido por'
                        "(SELECT array_agg(occupationName)::text[] <@ ARRAY['" + occupations + "'] " +
                                "FROM Property_Occupation " +
                                "WHERE Property_Occupation.propertyId = Property.id)"
                );
            }

            // Filters - Pets
            if (hasPets && !notPets) { conditions.add("Property.petsQuantity > 0"); }
            if (notPets && !hasPets) { conditions.add("Property.petsQuantity <= 0"); }

            // Filters - Smokers
            if (hasSmokers && !notSmokers) { conditions.add("Property.smokers > 0"); }
            if (notSmokers && !hasSmokers) { conditions.add("Property.smokers <= 0"); }
        }

        // Filters - Furnished
        if (furnished && !notFurnished) { conditions.add("(Property.furnished OR Bedroom.furnished)"); }
        if (notFurnished && !furnished) { conditions.add("(NOT (Property.furnished OR Bedroom.furnished))"); }

        if (sharedType) {
            // Filters - Total Access
            if (totalAccess && !notTotalAcess) { conditions.add("Property.totalAccess"); }
            if (notTotalAcess && !totalAccess) { conditions.add("(NOT Property.totalAccess)"); }
        }

        // User Information - Gender
        if (userGender != null) {
            String gender = userGender.getName();
            if (gender.equals("undefined")) {
                gender = "undefined', 'female', 'male";
            }
            conditions.add("(Property.genderName IN ('" + gender + "'))");
        }

        // User Information - Occupation
        if (userOccupation != null) {
            conditions.add(
                    "(SELECT '" + userOccupation.getName() + "' = ANY(array_agg(occupationName)) " +
                            "FROM Property_Occupation2 " +
                            "WHERE Property_Occupation2.propertyId = Property.id)"
            );
        }

        // User Information - Age
        if (userAge != null) {
            conditions.add("(Property.allowedMinAge IS NULL OR Property.allowedMinAge <= " + userAge + ") " +
                    "AND (Property.allowedMaxAge IS NULL OR Property.allowedMaxAge >= " + userAge + ")");
        }

        // QUERY BUILDING AND EXECUTION
        return PropertyDAO.listPropertyBySQLQuery(
                tables.isEmpty() ? null : " LEFT JOIN " +  String.join(" LEFT JOIN ", tables),
                conditions.isEmpty() ? null : String.join(" AND ", conditions),
                mapOrdinationToOrderBy(ordination, sharedType, privateType, sell, rent),
                Integer.toString(propsPerPage * numberOfPages), Integer.toString(page * propsPerPage),
                parameters
        );
    }
}
