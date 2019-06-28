package web;

import business.Home4All;
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

import static web.Parser.parseToFloat;
import static web.Parser.parseToInt;


@WebServlet(name = "PropertiesSearch", urlPatterns = {"/search/*"})
@MultipartConfig
public class PropertiesSearch extends HttpServlet {
    private Gson gson = new Gson();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            Map<String, Object> data = gson.fromJson(request.getParameter("payload"), Map.class);
            Map<String, Object> filters = (Map<String, Object>) data.get("filters");

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


            List<Property> results = Home4All.searchProperties(
                    (String) data.get("district"),
                    (String) data.get("city"),
                    (String) data.get("address"),
                    parseToInt(filters.get("page"), false), //0,
                    parseToInt(filters.get("perPage"), false), //10,
                    parseToInt(filters.get("numPages"), false), //2,
                    (List<String>) filters.get("types"),
                    (List<String>) filters.get("typologies"),
                    (boolean) filters.get("sell"),
                    (boolean) filters.get("rent"),
                    parseToFloat(filters.get("minSellPrice"), true),
                    parseToFloat(filters.get("maxSellPrice"), true),
                    parseToFloat(filters.get("minRentPrice"), true),
                    parseToFloat(filters.get("maxRentPrice"), true),
                    (List<String>) filters.get("bedroomTypes"),
                    parseToInt(filters.get("peopleAmountMultiple"), true),
                    (boolean) filters.get("privateWC"),
                    (boolean) filters.get("sharedWC"),
                    (List<String>) filters.get("hasOccupations"),
                    (boolean) filters.get("hasPets"),
                    (boolean) filters.get("notPets"),
                    (boolean) filters.get("hasSmokers"),
                    (boolean) filters.get("notSmokers"),
                    (boolean) filters.get("furnished"),
                    (boolean) filters.get("notFurnished"),
                    (boolean) filters.get("totalAccess"),
                    (boolean) filters.get("notTotalAccess"),
                    (String) filters.get("ordination"),
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
