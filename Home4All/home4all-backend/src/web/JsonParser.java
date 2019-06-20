package web;

import business.entities.*;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

class JsonParser {
    private static Gson gson = new Gson();

    static String userToJson(Common user) {
        LinkedTreeMap data = new LinkedTreeMap();
        data.put("id", user.getID());
        data.put("email", user.getEmail());
        data.put("name", user.getName());
        if (user instanceof InternalAccount) {
            data.put("password", ((InternalAccount) user).getPassword());
        }
        data.put("age", user.getAge());
        data.put("phone", user.getPhone());
        return gson.toJson(data);
    }

    static String usersToJson(List<business.entities.Users> users) {
        List<Map<String, Object>> data = new ArrayList<>();
        for (business.entities.Users user: users) {
            Map<String, Object> userData = new HashMap<>();
            userData.put("id", user.getID());
            userData.put("email", user.getEmail());
            userData.put("name", user.getName());
            if (user instanceof InternalAccount) {
                userData.put("password", ((InternalAccount) user).getPassword());
            }
            if (user instanceof Common) {
                userData.put("age", ((Common) user).getAge());
                userData.put("phone", ((Common) user).getPhone());
                data.add(userData);
            }
        }
        return gson.toJson(data);
    }

    private static List<String> mapPathsToImages(Photo[] photos) throws IOException {
        List<String> images = new ArrayList<>();
        for (Photo photo: photos) {
            File file = new File("images" + File.separator + photo.getPath());
            byte[] bytes = Files.readAllBytes(file.toPath());
            String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(bytes);
            images.add(encodeImage);
        }
        return images;
    }

    static String propertyToJson(Property property) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Map<String, Object> data = new HashMap<>();
        data.put("id", property.getID());
        data.put("name", property.getName());
        data.put("images", mapPathsToImages(property.photos.toArray()));
        data.put("description", property.getDescription());
        data.put("typology", property.getTypology().getName());
        data.put("area", property.getArea());

        Address address = property.getAddress();
        data.put("district", address.getDistrict());
        data.put("city", address.getCity());
        data.put("address", address.getCompleteAddress());
        data.put("lat", address.getCoordLat());
        data.put("lng", address.getCoordLng());

        List<String> aux = Arrays.stream(property.equipmentIncluded.toArray())
                    .map(Equipment::getName)
                    .collect(Collectors.toList());
        data.put("equipmentIncluded", aux);

        if (property instanceof Shared || ((Private) property).getRentPrice() != null) {
            aux = Arrays.stream(property.expensesIncluded.toArray())
                    .map(Expenses::getName)
                    .collect(Collectors.toList());
            data.put("expensesIncluded", aux);

            data.put("allowedGenders", property.getAllowedGenders().getName());
            data.put("allowedMinAge", property.getAllowedMinAge());
            data.put("allowedMaxAge", property.getAllowedMaxAge());
            data.put("allowedSmokers", property.getAllowedSmoker());
            data.put("allowedPets", property.getAllowedPets());
            aux = Arrays.stream(property.allowedOccupations.toArray())
                    .map(Occupation::getName)
                    .collect(Collectors.toList());
            data.put("allowedOccupations", aux);
        }

        if (property instanceof Shared) {
            Shared shared = (Shared) property;
            data.put("type", "bedrooms");

            List<Map<String,Object>> bedrooms = new ArrayList<>();

            for (Bedroom bedroom: shared.bedrooms.toArray()) {
                Map<String,Object> b = new HashMap<>();
                b.put("id", bedroom.getID());
                b.put("area", bedroom.getArea());
                b.put("availability", dateFormat.format(bedroom.getAvailability()));
                b.put("furnished", bedroom.getFurnished());
                b.put("type", bedroom.getType().getName());
                b.put("peopleAmount", bedroom.getPeopleAmount());
                b.put("privateBathroom", bedroom.getPrivateBathroom());
                b.put("rentPrice", bedroom.getRentPrice());
                b.put("sold", bedroom.getSold());
                b.put("images", mapPathsToImages(bedroom.photos.toArray()));
                bedrooms.add(b);
            }
            data.put("bedrooms", bedrooms);

            data.put("females", shared.getFemales());
            data.put("males", shared.getMales());
            data.put("smokers", shared.getSmokers());
            data.put("petsQuantity", shared.getPetsQuantity());

            aux = Arrays.stream(shared.pets.toArray())
                    .map(Pet::getType)
                    .collect(Collectors.toList());
            data.put("pets", aux);

            aux = Arrays.stream(((Shared) property).occupations.toArray())
                    .map(Occupation::getName)
                    .collect(Collectors.toList());
            data.put("occupations", aux);

            data.put("totalAccess", shared.getTotalAccess());
        }
        else if (property instanceof Private) {
            Private priv = (Private) property;

            if (priv instanceof Villa)
                data.put("type", "villa");
            else if (priv instanceof Apartment)
                data.put("type", "apartment");

            data.put("furnished", priv.getFurnished());
            data.put("availability", dateFormat.format(priv.getAvailability()));
            data.put("rent", priv.getRentPrice() != null);
            data.put("sell", priv.getSellPrice() != null);
            data.put("rentPrice", priv.getRentPrice());
            data.put("sellPrice", priv.getSellPrice());
        }

        return gson.toJson(data);
    }
}
