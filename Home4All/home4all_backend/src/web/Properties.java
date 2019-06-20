package web;

import business.Home4All;
import business.entities.Property;
import com.google.gson.Gson;
import org.orm.PersistentException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@WebServlet(name = "Properties", urlPatterns = {"/properties"})
@MultipartConfig
public class Properties extends HttpServlet {
    private Gson gson = new Gson();

    private String saveNewImage(Part p) throws PersistentException, IOException {
        // Obtenção do nome e formato da imagem
        String name = p.getSubmittedFileName();
        name = Home4All.nextImageName(name.substring(0, name.lastIndexOf('.'))
                .substring(name.lastIndexOf(File.separator) + 1));
        String format = p.getContentType().replace("image/", "");

        // Criar ficheiro para armazenar a imagem
        File file = new File("images" + File.separator + name + "." + format);
        file.mkdirs();

        // Ler e armazenar a imagem
        BufferedImage image = ImageIO.read(p.getInputStream());
        ImageIO.write(image, format, file);

        return name + "." + format;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Collection<Part> parts = request.getParts();
            List<String> imagesPaths = new ArrayList<>();
            List<List<String>> bedroomsImagesPaths = new ArrayList<>();
            Map<String,Object> data = null;
            for (Part p: parts) {
                if (p.getName().startsWith("image")) {
                    String name = saveNewImage(p);
                    imagesPaths.add(name);
                }
                else if (p.getName().startsWith("bedImage")) {
                    String name = saveNewImage(p);
                    String aux = p.getName();
                    int i = Integer.parseInt(aux.substring(aux.indexOf('[') + 1, aux.indexOf(']')));
                    // TODO: Verificar necessidade de utilizar o 'j'
                    while (i >= bedroomsImagesPaths.size()) {
                        bedroomsImagesPaths.add(new ArrayList<>());
                    }
                    bedroomsImagesPaths.get(i).add(name);
                }
                else if (p.getName().equals("property") && data == null) {
                    Scanner scanner = new Scanner(p.getInputStream(),"UTF-8");
                    StringBuilder sb = new StringBuilder();
                    while (scanner.hasNextLine())
                        sb.append(scanner.nextLine());

                    data = gson.fromJson(sb.toString(), Map.class);
                }
                else if (!p.getName().equals("bedrooms")) {
                    throw new Exception("ERRO: Parâmetro \"" + p.getName() + "\" desconhecido.");
                }
            }

            Property property;
            String operation = (String) data.get("operation");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            int i = 0;
            for (Map<String, Object> bedroomProps : (List<Map<String, Object>>) data.get("bedrooms")) {
                bedroomProps.put("images", bedroomsImagesPaths.get(i));
                bedroomProps.put("availability", dateFormat.parse((String) bedroomProps.get("availability")));
                i++;
            }

            System.out.println(data);
            System.out.println(imagesPaths);

            if (data.containsKey("type")) {
                if (data.get("type").equals("bedrooms")) {
                    property = Home4All.registerSharedProperty(
                            (String) data.get("name"),
                            imagesPaths,
                            (String) data.get("description"),
                            (String) data.get("type"),
                            (String) data.get("typology"),
                            Float.parseFloat((String) data.get("area")),
                            (String) data.get("district"),
                            (String) data.get("city"),
                            (String) data.get("street"),
                            (List<String>) data.get("rentInc"),
                            (List<String>) data.get("divEquipInc"),
                            Integer.parseInt((String) data.get("allowedMinAge")),
                            Integer.parseInt((String) data.get("allowedMaxAge")),
                            (boolean) data.get("allowedSmoker"),
                            (boolean) data.get("allowedPets"),
                            (List<String>) data.getOrDefault("allowedOcupations", new ArrayList<>()),
                            (String) data.get("allowedGenre"),
                            Integer.parseInt((String) data.get("females")),
                            Integer.parseInt((String) data.get("males")),
                            Integer.parseInt((String) data.get("smokers")),
                            Integer.parseInt((String) data.get("pets")),
                            (List<String>) data.getOrDefault("petsType", new ArrayList<>()), // TODO: Falta no front-end
                            (List<String>) data.getOrDefault("ocupations", new ArrayList<>()),
                            (boolean) data.getOrDefault("totalAccess", false), // TODO: Falta no front-end
                            (List<Map<String, Object>>) data.get("bedrooms"),
                            0 // TODO: Colocar o ownerId
                    );
                }
                else if (data.get("type").equals("apartment") || data.get("type").equals("villa")) {
                    property = Home4All.registerPrivateProperty(
                            (String) data.get("name"),
                            imagesPaths,
                            (String) data.get("description"),
                            (String) data.get("type"),
                            (String) data.get("typology"),
                            Float.parseFloat((String) data.get("area")),
                            (String) data.get("district"),
                            (String) data.get("city"),
                            (String) data.get("street"),
                            (boolean) data.get("furnished"),
                            dateFormat.parse((String) data.get("availability")),
                            operation.equals("rent") || operation.equals("both"),
                            operation.equals("sell") || operation.equals("both"),
                            Float.parseFloat((String) data.get("rentPrice")),
                            Float.parseFloat((String) data.get("sellPrice")),
                            (List<String>) data.get("rentInc"),
                            (List<String>) data.get("divEquipInc"),
                            Integer.parseInt((String) data.get("allowedMinAge")),
                            Integer.parseInt((String) data.get("allowedMaxAge")),
                            (boolean) data.get("allowedSmoker"),
                            (boolean) data.get("allowedPets"),
                            (List<String>) data.get("allowedOcupations"),
                            (String) data.get("allowedGenre"),
                            0 // TODO: Colocar o ownerId
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
            response.setContentType("application/json"); // multipart/form-data
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
