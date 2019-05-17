package web;

import business.Home4All;
import business.entities.Property;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Properties", urlPatterns = {"/properties"})
public class Properties extends HttpServlet {
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map data = gson.fromJson(request.getReader(), Map.class);
            System.out.println(data);
            Property property;
            String selectedOp = (String) data.get("selectedOperation");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (data.containsKey("selectedType")) {
                if (data.get("selectedType").equals("bedrooms")) {
                    property = Home4All.registerSharedProperty(
                            (String) data.get("name"),
                            (List<byte[]>) null, // TODO: Photos
                            (String) data.get("description"),
                            (String) data.get("selectedType"),
                            (String) data.get("selectedTypology"),
                            Float.parseFloat((String) data.get("area")),
                            (String) data.get("selectedDistrict"),
                            (String) data.get("selectedCity"),
                            (String) data.get("street"),
                            (List<String>) data.get("selectedRentInc"),
                            (List<String>) data.get("selectedDivEquipInc"),
                            Integer.parseInt((String) data.get("allowedMinAge")),
                            Integer.parseInt((String) data.get("allowedMaxAge")),
                            (boolean) data.get("allowedSmoker"),
                            (boolean) data.get("allowedPets"),
                            (List<String>) data.get("selectedOcupation"),
                            (String) data.get("selectedGenre"),
                            Integer.parseInt((String) data.getOrDefault("currentFemalesQt", 0)),
                            Integer.parseInt((String) data.getOrDefault("currentMalesQt", 0)),
                            Integer.parseInt((String) data.getOrDefault("currentSmokersQt", 0)),
                            Integer.parseInt((String) data.getOrDefault("currentPetsQt", 0)),
                            (List<String>) data.getOrDefault("currentPets", new String[0]),
                            (List<String>) data.getOrDefault("currentOccupations", new String[0]),
                            (boolean) data.getOrDefault("totalAccess", false),
                            Arrays.asList((Map) data.get("bedrooms"))
                    );
                }
                else if (data.get("selectedType").equals("apartment") || data.get("selectedType").equals("villa")) {
                    property = Home4All.registerPrivateProperty(
                            (String) data.get("name"),
                            (List<byte[]>) null, // TODO: Photos
                            (String) data.get("description"),
                            (String) data.get("selectedType"),
                            (String) data.get("selectedTypology"),
                            Float.parseFloat((String) data.get("area")),
                            (String) data.get("selectedDistrict"),
                            (String) data.get("selectedCity"),
                            (String) data.get("street"),
                            (boolean) data.get("furnished"),
                            dateFormat.parse((String) data.get("availability")),
                            selectedOp.equals("rent") || selectedOp.equals("both"),
                            selectedOp.equals("sell") || selectedOp.equals("both"),
                            Float.parseFloat((String) data.get("rentPrice")),
                            Float.parseFloat((String) data.get("sellPrice")),
                            (List<String>) data.get("selectedRentInc"),
                            (List<String>) data.get("selectedDivEquipInc"),
                            Integer.parseInt((String) data.get("allowedMinAge")),
                            Integer.parseInt((String) data.get("allowedMaxAge")),
                            (boolean) data.get("allowedSmoker"),
                            (boolean) data.get("allowedPets"),
                            (List<String>) data.get("selectedOcupation"),
                            (String) data.get("selectedGenre")
                    );
                }
                else {
                    throw new Exception("ERRO: Tipo de imóvel selecionado inválido.");
                }
            }
            else {
                throw new Exception("ERRO: Obrigatório selecionar tipo de imóvel.");
            }

            String propertyJsonString = JsonParser.propertyToJson(property);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(propertyJsonString);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
