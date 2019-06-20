package web;

import business.Home4All;
import business.entities.Common;
import business.entities.InternalAccount;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends HttpServlet {
    private Gson gson = new Gson();
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("POST USERS");
        try {
            BufferedReader reader = request.getReader();
            InternalAccount u = gson.fromJson(reader, InternalAccount.class);
            Common user = Home4All.insertCommonUser(u.getEmail(), u.getName(), u.getPassword(), u.getAge(), u.getPhone(),
                                                    null, null);
            String userJsonString = JsonParser.userToJson(user);
            response.setContentType("application/json"); // multipart/form-data
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(userJsonString);
            out.flush();
        }
        catch (Exception e) {
            LOGGER.info("FAILED POST");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            System.out.println("USER AUTHENTICATED:" + currentUser.getEmail());
            System.out.println("SESSION ID: " + session.getId());
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
