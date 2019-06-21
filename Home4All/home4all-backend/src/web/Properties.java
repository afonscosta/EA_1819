package web;

import business.Home4All;
import business.entities.Property;
import business.entities.Users;
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

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    private String saveNewImage(Part p) throws PersistentException, IOException {
        // Obtenção do nome e formato da imagem
        String name = getSubmittedFileName(p);
        String format = p.getContentType().replace("image/", "");
        String name_format = Home4All.nextImageName(
                name.substring(0, name.lastIndexOf('.'))
                    .substring(name.lastIndexOf(File.separator) + 1),
                format);

        // Criar ficheiro para armazenar a imagem
        File file = new File("images" + File.separator + name_format);
        file.mkdirs();

        // Ler e armazenar a imagem
        BufferedImage image = ImageIO.read(p.getInputStream());
        ImageIO.write(image, format, file);

        return name_format;
    }

    private Float parseToFloat(Object o, boolean allowNulls) throws Exception {
        try {
            if (o == null && allowNulls) {
                return null;
            }
            else if (o instanceof String) {
                if (((String) o).isEmpty()) {
                    if (allowNulls)
                        return null;
                }
                else
                    return Float.parseFloat((String) o);
            }
            else if (o instanceof Double) {
                return Float.parseFloat(Double.toString((double) o));
            }
            else if (o instanceof Float || o instanceof Integer) {
                return (float) o;
            }
        }
        catch (Exception e) {
            throw new Exception("ERRO: Tipo de dados inesperado (<" + o + "> é do tipo " + o.getClass() + ", mas deveria ser float).");
        }
        throw new Exception("ERRO: Tipo de dados inesperado (<" + o + "> é do tipo " + o.getClass() + ", mas deveria ser float).");
    }

    private Integer parseToInt(Object o, boolean allowNulls) throws Exception {
        try {
            if (o == null && allowNulls) {
                return null;
            }
            else if (o instanceof String) {
                if (((String) o).isEmpty()) {
                    if (allowNulls)
                        return null;
                }
                else
                    return Integer.parseInt((String) o);
            }
            else if ((o instanceof Double || o instanceof Float)
                    && ((double) o) % 1 == 0) {
                return (int) Math.round((double) o);
            }
            else if (o instanceof Integer) {
                return (int) o;
            }
        }
        catch (Exception e) {
            throw new Exception("ERRO: Tipo de dados inesperado (<" + o + "> é do tipo " + o.getClass() + ", mas deveria ser inteiro).");
        }
        throw new Exception("ERRO: Tipo de dados inesperado (<" + o + "> é do tipo " + o.getClass() + ", mas deveria ser inteiro).");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Users u = (Users) request.getSession().getAttribute("currentSessionUser");

            if (u != null && u.getID() > 0) {
                Collection<Part> parts = request.getParts();
                List<String> imagesPaths = new ArrayList<>();
                List<List<String>> bedroomsImagesPaths = new ArrayList<>();
                Map<String, Object> data = null;
                for (Part p : parts) {
                    if (p.getName().startsWith("image")) {
                        String name = saveNewImage(p);
                        imagesPaths.add(name);
                    } else if (p.getName().startsWith("bedImage")) {
                        String name = saveNewImage(p);
                        String aux = p.getName();
                        int i = Integer.parseInt(aux.substring(aux.indexOf('[') + 1, aux.indexOf(']')));
                        while (i >= bedroomsImagesPaths.size()) {
                            bedroomsImagesPaths.add(new ArrayList<>());
                        }
                        bedroomsImagesPaths.get(i).add(name);
                    } else if (p.getName().equals("property") && data == null) {
                        Scanner scanner = new Scanner(p.getInputStream(), "UTF-8");
                        StringBuilder sb = new StringBuilder();
                        while (scanner.hasNextLine())
                            sb.append(scanner.nextLine());

                        data = gson.fromJson(sb.toString(), Map.class);
                    } else if (!p.getName().equals("bedrooms")) {
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

                if (data.containsKey("type")) {
                    if (data.get("type").equals("bedrooms")) {
                        property = Home4All.registerSharedProperty(
                                parseToInt(data.get("id"), true),
                                (String) data.get("name"),
                                imagesPaths,
                                (String) data.get("description"),
                                (String) data.get("typology"),
                                parseToFloat(data.get("area"), false),
                                (String) data.get("district"),
                                (String) data.get("city"),
                                (String) data.get("address"),
                                parseToFloat(data.get("lat"), false),
                                parseToFloat(data.get("lng"), false),
                                (List<String>) data.get("rentInc"),
                                (List<String>) data.get("divEquipInc"),
                                parseToInt(data.get("allowedMinAge"), true),
                                parseToInt(data.get("allowedMaxAge"), true),
                                (boolean) data.get("allowedSmoker"),
                                (boolean) data.get("allowedPets"),
                                (List<String>) data.getOrDefault("allowedOcupations", new ArrayList<>()),
                                (String) data.get("allowedGenre"),
                                parseToInt(data.get("females"), false),
                                parseToInt(data.get("males"), false),
                                parseToInt(data.get("smokers"), false),
                                parseToInt(data.get("pets"), false),
                                (List<String>) data.getOrDefault("petsType", new ArrayList<>()),
                                (List<String>) data.getOrDefault("ocupations", new ArrayList<>()),
                                (boolean) data.getOrDefault("totalAccess", false),
                                (List<Map<String, Object>>) data.get("bedrooms"),
                                u.getID()
                        );
                    } else if (data.get("type").equals("apartment") || data.get("type").equals("villa")) {
                        property = Home4All.registerPrivateProperty(
                                parseToInt(data.get("id"), true),
                                (String) data.get("name"),
                                imagesPaths,
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
                                operation.equals("rent") || operation.equals("both"),
                                operation.equals("sell") || operation.equals("both"),
                                parseToFloat(data.get("rentPrice"), true),
                                parseToFloat(data.get("sellPrice"), true),
                                (List<String>) data.get("rentInc"),
                                (List<String>) data.get("divEquipInc"),
                                parseToInt(data.get("allowedMinAge"), true),
                                parseToInt(data.get("allowedMaxAge"), true),
                                (boolean) data.get("allowedSmoker"),
                                (boolean) data.get("allowedPets"),
                                (List<String>) data.get("allowedOcupations"),
                                (String) data.get("allowedGenre"),
                                u.getID()
                        );
                    } else {
                        throw new Exception("ERRO: Tipo de imóvel selecionado inválido.");
                    }
                } else {
                    throw new Exception("ERRO: Obrigatório selecionar tipo de imóvel.");
                }

                String propertyJsonString = JsonParser.propertyToJson(property);
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
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            // TODO: Em caso de erro enviar mensagem explicativa
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
                    jsonData = JsonParser.propertyToJson(property);
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
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }
}
