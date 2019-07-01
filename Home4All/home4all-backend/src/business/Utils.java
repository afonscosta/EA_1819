package business;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import redis.clients.jedis.Jedis;
import sun.security.jgss.GSSCaller;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.*;

public class Utils {
    // Trocar '_' final nos métodos para funcionar remotamente

    public static List<String> getImages(List<String> filenames) {
        List<String> images = new ArrayList<>();

        try {
            for (String filename: filenames) {
                java.io.File file = new java.io.File("images" + java.io.File.separator + filename);
                byte[] bytes = Files.readAllBytes(file.toPath());
                images.add(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return images;
    }

    public static String getImage(String filename) {
        java.io.File file = new java.io.File("images" + java.io.File.separator + filename);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(bytes);
    }

    public static void deleteImages(List<String> filenames) {
        List<String> images = new ArrayList<>();

        for (String filename: filenames) {
            java.io.File file = new java.io.File("images" + java.io.File.separator + filename);
            file.delete();
        }
    }


    public static void saveImages(Map<String, String> filenames_images) throws IOException {

        for (Map.Entry<String, String> filename_image : filenames_images.entrySet()) {
            Path file = Paths.get("images" + java.io.File.separator + filename_image.getKey());
            Files.write(file, filename_image.getValue().getBytes());
        }
    }



    public static List<String> getImages_(Jedis jedis, List<String> filenames) {
        List<String> images = new ArrayList<>();

        for (String filename: filenames)
            images.add(jedis.get(filename));

        return images;
    }


    public static String getImage_(Jedis jedis, String path) {
        return jedis.get(path);
    }

    public static void deleteImages_(Jedis jedis, List<String> filenames) {
        for (String filename: filenames)
            jedis.del(filename);
    }


    public static void saveImages_(Jedis jedis, Map<String, String> filenames_images) {
        for (Map.Entry<String, String> filename_image: filenames_images.entrySet())
            jedis.set(filename_image.getKey(), filename_image.getValue());
    }


    public static String md5(String original) {
        String hash = original;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static String generateAvatar(String email) {
        email = email.trim().toLowerCase();
        String hash = md5(email);
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpGet request = new HttpGet("https://www.gravatar.com/avatar/" + hash + ".png?d=retro");
            request.addHeader("User-Agent", "Mozilla/5.0");
            HttpResponse response = httpClient.execute(request);
            String image_b64 = Base64.getEncoder().encodeToString(EntityUtils.toByteArray(response.getEntity()));
            return "data:image/png;base64," + image_b64;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> getAddress(String address) throws UnsupportedEncodingException {
        address = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
        HttpClient httpClient = HttpClientBuilder.create().build();
        Map<String, Object> result = new HashMap<>();
        Gson gson = new Gson();
        try {
            HttpGet request = new HttpGet("https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + address + "&components=country:pt&language=pt-PT&key=AIzaSyDtZzBGMqTFWjndSRR-kEzpwBMdHodA5Ac");
            HttpResponse response = httpClient.execute(request);
            Map<String, List<Map<String, Object>>> places = gson.fromJson(EntityUtils.toString(response.getEntity()), Map.class);
            String placeId = places.get("predictions").get(0).get("place_id").toString();
            request = new HttpGet("https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&language=pt-PT&key=AIzaSyDtZzBGMqTFWjndSRR-kEzpwBMdHodA5Ac");
            response = httpClient.execute(request);
            Map<String, Object> place = (Map<String, Object>) gson.fromJson(EntityUtils.toString(response.getEntity()), Map.class).get("result");
            List<Map<String, Object>> addressComponents = (List<Map<String, Object>>) place.get("address_components");
            String city = null;
            String district = null;
            for (Map<String, Object> component : addressComponents) {
                List<String> types = (List<String>) component.get("types");
                if (types.contains("locality") && types.contains("political")) {
                    city = (String) component.get("long_name");
                }
                if (types.contains("administrative_area_level_1") && types.contains("political")) {
                    district = (String) component.get("long_name");
                }
            }
            String formattedAddress = place.get("formatted_address").toString();

            Map<String, Double> location = ((Map<String, Map<String, Double>>) place.get("geometry")).get("location");
            float lat = Float.parseFloat(Double.toString(location.get("lat")));
            float lng = Float.parseFloat(Double.toString(location.get("lng")));

            result.put("district", district);
            result.put("city", city);
            result.put("formattedAddress", formattedAddress);
            result.put("lat", lat);
            result.put("lng", lng);

            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String hash(String original) {
        String res = original;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(original.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            res = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
