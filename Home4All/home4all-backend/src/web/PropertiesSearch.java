package web;

import business.Home4All;
import business.Parser;
import business.entities.*;
import business.entities.Users;
import com.google.gson.Gson;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static business.Parser.parseToFloat;
import static business.Parser.parseToInt;


@WebServlet(name = "PropertiesSearch", urlPatterns = {"/search/*"})
@MultipartConfig
public class PropertiesSearch extends HttpServlet {
    private Gson gson = new Gson();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            Map<String, Object> data = gson.fromJson(request.getParameter("payload"), Map.class);
            Map<String, Object> filters = (Map<String, Object>) data.getOrDefault("filters", new HashMap<>());

            HttpSession s = request.getSession(false);
            Gender userGender = null;
            Occupation userOccupation = null;
            Integer userAge = null;

            if (s != null) {
                if (s.getAttribute("currentSessionUser") != null) {
                    Users user = (Users) s.getAttribute("currentSessionUser");
                    if (user instanceof Common) {
                        Common u = (Common) s.getAttribute("currentSessionUser");
                        userGender = u.getGender();
                        userOccupation = u.getOccupation();
                        userAge = u.getAge();
                    }
                }
            }

            Object district = data.get("district");
            Object city = data.get("city");
            Object address = data.get("address");
            List<Property> results = Home4All.searchProperties(
                district == null ? null : (String) district,
                city == null ? null : (String) city,
                address == null ? null : (String) address,
                parseToInt(filters.get("page"), false), //0,
                parseToInt(filters.get("perPage"), false), //10,
                parseToInt(filters.get("numPages"), false), //2,
                (List<String>) filters.getOrDefault("types", new ArrayList<>()),
                (List<String>) filters.getOrDefault("typologies", new ArrayList<>()),
                (boolean) filters.getOrDefault("sell",false),
                (boolean) filters.getOrDefault("rent",false),
                parseToFloat(filters.get("minSellPrice"), true),
                parseToFloat(filters.get("maxSellPrice"), true),
                parseToFloat(filters.get("minRentPrice"), true),
                parseToFloat(filters.get("maxRentPrice"), true),
                (List<String>) filters.getOrDefault("bedroomTypes", new ArrayList<>()),
                parseToInt(filters.get("peopleAmountMultiple"), true),
                (boolean) filters.getOrDefault("privateWC",false),
                (boolean) filters.getOrDefault("sharedWC", true),
                (List<String>) filters.getOrDefault("hasOccupations", new ArrayList<>()),
                (boolean) filters.getOrDefault("hasPets",true),
                (boolean) filters.getOrDefault("notPets",true),
                (boolean) filters.getOrDefault("hasSmokers",true),
                (boolean) filters.getOrDefault("notSmokers",true),
                (boolean) filters.getOrDefault("furnished",true),
                (boolean) filters.getOrDefault("notFurnished",true),
                (boolean) filters.getOrDefault("totalAccess",true),
                (boolean) filters.getOrDefault("notTotalAccess",true),
                (String) filters.getOrDefault("ordination","Publication Date: newest first"),
                userGender,
                userOccupation,
                userAge
            );

            String jsonData = Parser.propertyListToJson(results);

            response.setContentType("application/json"); // multipart/form-data
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonData);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
