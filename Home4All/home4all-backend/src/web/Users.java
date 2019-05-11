package web;

import business.Home4All;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends javax.servlet.http.HttpServlet {
    private Gson gson = new Gson();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            BufferedReader reader = request.getReader();
            PSM.InternalAccount u = gson.fromJson(reader, PSM.InternalAccount.class);
            PSM.Users user = Home4All.insertCommonUser(u.getEmail(), u.getName(), u.getPassword(), u.getAge(), u.getPhone());
            String userJsonString = new Gson().toJson(user);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(userJsonString);
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
            List<PSM.Users> users = Home4All.listUsers();
            String usersJsonString = new Gson().toJson(users);
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
