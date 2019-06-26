package web;

import business.Home4All;
import business.entities.Admin;
import business.entities.Common;
import business.entities.InternalAccount;
import business.entities.Users;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
            Users currentUser = Home4All.login(email, password);

            if (currentUser!=null) {
                /*
                Enumeration<String> headers = request.getHeaderNames();
                while (headers.hasMoreElements()) {
                    String header = headers.nextElement();
                    System.out.println(header);
                    System.out.println(request.getHeader(header));
                }
                */
                String data_parser;
                if (!(currentUser instanceof Admin)) {
                    boolean isBlocked = Home4All.isBlocked(currentUser.getID());
                    if(!isBlocked) {
                        session.setAttribute("currentSessionUser", currentUser);
                        Common info_user = Home4All.getUser(currentUser.getID());
                        data_parser = Parser.currentUserToJson(session.getId(), info_user);
                    }
                    else {
                        throw new Exception("ERRO: O utilizador está bloqueado");
                    }

                }
                else{
                    session.setAttribute("currentSessionUser", currentUser);
                    Users info_user = Home4All.getUserbyUsers(currentUser.getID());
                    System.out.println(info_user);
                    data_parser = Parser.currentAdminToJson(session.getId(), info_user);
                }
                response.setContentType("application/json"); // multipart/form-data
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print(data_parser);
                out.flush();
            }
            else{
                LOGGER.info("FAILED LOGIN");
                response.sendError(403);
            }
        } catch (Exception e) {
            LOGGER.info("FAILED LOGIN");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, e.getMessage());
            e.printStackTrace();
        }
    }
}

