package web;

import business.entities.Common;
import business.entities.InternalAccount;
import business.entities.Property;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    static String propertyToJson(Property property) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", property.getID());
        // TODO: complete
        return gson.toJson(data);
    }
}
