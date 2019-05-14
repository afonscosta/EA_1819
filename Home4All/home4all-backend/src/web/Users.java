package web;

import business.Home4All;
import business.entities.Common;
import business.entities.InternalAccount;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends javax.servlet.http.HttpServlet {
    private Gson gson = new Gson();


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        try {
            BufferedReader reader = request.getReader();
            InternalAccount u = gson.fromJson(reader, InternalAccount.class);
            Common user = Home4All.insertCommonUser(u.getEmail(), u.getName(), u.getPassword(), u.getAge(), u.getPhone());
            String userJsonString = JsonParser.userToJson(user);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(userJsonString);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        try {
            List<business.entities.Users> users = Home4All.listUsers();
            String usersJsonString = JsonParser.usersToJson(users);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(usersJsonString);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        }
    }
}
