package web;

import business.Home4All;
import business.entities.Property;
import business.entities.Users;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static web.Parser.parseToFloat;
import static web.Parser.parseToInt;


@WebServlet(name = "Properties", urlPatterns = {"/properties"})
@MultipartConfig
public class Properties extends HttpServlet {
    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Users u = (Users) request.getSession(false).getAttribute("currentSessionUser");

            if (u != null && u.getID() > 0) {
                Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine());
                }

                Map<String, Object> data = gson.fromJson(sb.toString(), Map.class);

                Property property;
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                for (Map<String, Object> bedroom : (List<Map<String, Object>>) data.get("bedrooms")) {
                    bedroom.put("availability", dateFormat.parse((String) bedroom.get("availability")));
                    bedroom.put("area", parseToFloat(bedroom.get("area"), false));
                    bedroom.put("rentPrice", parseToFloat(bedroom.get("rentPrice"), false));
                }

                if (data.containsKey("type")) {
                    if (data.get("type").equals("bedrooms")) {
                        property = Home4All.registerSharedProperty(
                                parseToInt(data.get("id"), true),
                                (String) data.get("name"),
                                (List<String>) data.get("images"),   // TODO: Guardar fotos em ficheiro
                                (String) data.get("description"),
                                (String) data.get("typology"),
                                parseToFloat(data.get("area"), false),
                                (String) data.get("district"),
                                (String) data.get("city"),
                                (String) data.get("address"),
                                parseToFloat(data.get("lat"), false),
                                parseToFloat(data.get("lng"), false),
                                (List<String>) data.get("expensesIncluded"),
                                (List<String>) data.get("equipmentIncluded"),
                                parseToInt(data.get("allowedMinAge"), true),
                                parseToInt(data.get("allowedMaxAge"), true),
                                (boolean) data.get("allowedSmokers"),
                                (boolean) data.get("allowedPets"),
                                (List<String>) data.getOrDefault("allowedOccupations", new ArrayList<>()),
                                (String) data.get("allowedGenders"),
                                parseToInt(data.get("females"), false),
                                parseToInt(data.get("males"), false),
                                parseToInt(data.get("smokers"), false),
                                parseToInt(data.get("petsQuantity"), false),
                                (List<String>) data.getOrDefault("pets", new ArrayList<>()),
                                (List<String>) data.getOrDefault("occupations", new ArrayList<>()),
                                (boolean) data.getOrDefault("totalAccess", false),
                                (List<Map<String, Object>>) data.get("bedrooms"),
                                u.getID()
                        );
                    } else if (data.get("type").equals("apartment") || data.get("type").equals("villa")) {
                        property = Home4All.registerPrivateProperty(
                                parseToInt(data.get("id"), true),
                                (String) data.get("name"),
                                (List<String>) data.get("images"),   // TODO: Guardar fotos em ficheiro
                                (String) data.get("description"),
                                (String) data.get("type"),
                                (String) data.get("typology"),
                                parseToFloat(data.get("area"), false),
                                (String) data.get("district"),
                                (String) data.get("city"),
                                (String) data.get("address"),
                                parseToFloat(data.get("lat"), false),
                                parseToFloat(data.get("lng"), false),
                                (boolean) data.get("furnished"),
                                dateFormat.parse((String) data.get("availability")),
                                (boolean) data.get("rent"),
                                (boolean) data.get("sell"),
                                parseToFloat(data.get("rentPrice"), true),
                                parseToFloat(data.get("sellPrice"), true),
                                (List<String>) data.get("expensesIncluded"),
                                (List<String>) data.get("equipmentIncluded"),
                                parseToInt(data.get("allowedMinAge"), true),
                                parseToInt(data.get("allowedMaxAge"), true),
                                (boolean) data.get("allowedSmokers"),
                                (boolean) data.get("allowedPets"),
                                (List<String>) data.get("allowedOccupations"),
                                (String) data.get("allowedGenders"),
                                u.getID()
                        );
                    } else {
                        throw new Exception("ERRO: Tipo de imóvel selecionado inválido.");
                    }
                } else {
                    throw new Exception("ERRO: Obrigatório selecionar tipo de imóvel.");
                }

                String propertyJsonString = Parser.propertyToJson(property);
                response.setContentType("application/json"); // multipart/form-data
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print(propertyJsonString);
                out.flush();
            }
            else {
                throw new Exception("ERRO: Tem de estar autenticado para inserir ou editar um imóvel.");
            }
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, e.getMessage());
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String jsonData;

            String id_str = request.getParameter("propertyId");
            if (id_str != null) {
                int id = Integer.parseInt(id_str);
                Property property = Home4All.getProperty(id);
                if (property != null) {
                    jsonData = Parser.propertyToJson(property);
                }
                else {
                    throw new Exception("ERRO: Imóvel não encontrado.");
                }
            }
            else {
                throw new Exception("ERRO: Identificador do imóvel em falta.");
            }

            response.setContentType("application/json"); // multipart/form-data
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonData);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, e.getMessage());
            e.printStackTrace();
        }
    }
}
