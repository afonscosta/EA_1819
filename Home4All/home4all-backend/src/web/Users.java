package web;

import business.Home4All;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends javax.servlet.http.HttpServlet {

    private Gson getGson() {
        // Trick to get the DefaultDateTypeAdatpter instance
        // Create a first instance a Gson
        Gson gson = new GsonBuilder()
                .setDateFormat(DateFormat.FULL)
                .create();

        // Get the date adapter
        TypeAdapter<Date> dateTypeAdapter = gson.getAdapter(Date.class);

        // Ensure the DateTypeAdapter is null safe
        TypeAdapter<Date> safeDateTypeAdapter = dateTypeAdapter.nullSafe();

        // Build the definitive safe Gson instance
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, safeDateTypeAdapter)
                .create();
    }

    private Gson gson = getGson();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            BufferedReader reader = request.getReader();
            //PSM.InternalAccount u = gson.fromJson(reader, PSM.InternalAccount.class);
            //PSM.Users user = Home4All.insertCommonUser(u.getEmail(), u.getName(), u.getPassword(), u.getAge(), u.getPhone());
            //System.out.println(user);
            //String userJsonString = gson.toJson(user);
            //System.out.println("SOU O JSON!");
            //System.out.println(userJsonString);
            StringBuffer jb = new StringBuffer();
            String line = null;
            while((line = reader.readLine()) != null) {
                jb.append(line);
                System.out.println(line);
            }
            //JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
            System.out.println("JSONObject");
            System.out.println(jb.toString());
            //System.out.println(jsonObject);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            //out.print(userJsonString);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            System.out.println("HERE");
            List<PSM.Users> users = Home4All.listUsers();
            System.out.println(users);
            String usersJsonString = gson.toJson(users);
            System.out.println(usersJsonString);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(usersJsonString);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        }
    }
}
