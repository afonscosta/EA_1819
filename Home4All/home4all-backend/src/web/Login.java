package web;

import business.entities.InternalAccount;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private Gson gson = new Gson();
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("LOGIN");
        try {
            //String user = request.getHeader("username");
            //String password = request.getHeader("password");
            //request.login(user, password);
            HttpSession session = request.getSession(true);
            String id = session.getId();
            BufferedReader reader = request.getReader();
            LinkedTreeMap data = new LinkedTreeMap();
            data.put("id", id);
            response.setContentType("application/json"); // multipart/form-data
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(data));
            out.flush();
        } catch (Exception e) {
            LOGGER.info("FAILED POST");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }
    }
}

