package web;

import business.entities.InternalAccount;
import business.entities.Users;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import data.UsersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private Gson gson = new Gson();
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("LOGIN");
        try {
            HttpSession session = request.getSession(true);
            BufferedReader reader = request.getReader();
            Map user = gson.fromJson(reader, Map.class);
            String email = (String) user.get("email");
            String password = (String) user.get("password");
            System.out.println("Autenticate user " + email + "...");
            Users currentUser = UsersDAO.loadUsersByQuery("email='"+email+"' AND password='"+password+"'", null);
            if (currentUser!=null) {
                session.setAttribute("currentSessionUser", currentUser);
                Enumeration<String> headers = request.getHeaderNames();
                while (headers.hasMoreElements()) {
                    String header = headers.nextElement();
                    System.out.println(header);
                    System.out.println(request.getHeader(header));
                }
                LinkedTreeMap data = new LinkedTreeMap();
                data.put("id", session.getId());
                response.setContentType("application/json"); // multipart/form-data
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print(gson.toJson(data));
                LOGGER.info("FINISH LOGIN");
                out.flush();
            }
            else{
                LOGGER.info("FAILED LOGGIN");
                response.sendError(403);
            }
        } catch (Exception e) {
            LOGGER.info("FAILED LOGIN");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }
}

