package web;

import business.Home4All;
import business.Parser;
import business.entities.Admin;
import business.entities.Common;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(name = "Users", urlPatterns = {"/users/*"})
public class Users extends HttpServlet {
    private Gson gson = new Gson();
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("POST USERS");
        try {
            BufferedReader reader = request.getReader();
            Map u = gson.fromJson(reader, Map.class);
            Common user = Home4All.insertCommonUser((String) u.getOrDefault("email", null),
                                                    (String) u.getOrDefault("name",null),
                                                    (String) u.getOrDefault("password", null),
                                                    (String) u.getOrDefault("birthday", null),
                                                    (String) u.getOrDefault("phone", null),
                                                    (String) u.getOrDefault("gender",null),
                                                    (String) u.getOrDefault("occupation", null));
            String userJsonString = Parser.userToJson(user);
            response.setContentType("application/json");
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
        LOGGER.info("GET USERS");
        try {
            String jsonData;

            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            System.out.println("USER AUTHENTICATED:" + currentUser.getEmail());
            System.out.println("SESSION ID: " + session.getId());
            Common user = Home4All.getUser(currentUser.getID());
            if (user != null) {
                jsonData = Parser.userToJson(user);
            }
            else {
                throw new Exception("ERRO: User não encontrado.");
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonData);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND, e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("PUT USERS");
        try {
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            BufferedReader reader = request.getReader();
            Map u = gson.fromJson(reader, Map.class);
            System.out.println(currentUser.getID());
            Common user = Home4All.updateCommonUser( currentUser.getID(),
                                                    (String) u.getOrDefault("name",null),
                                                    (String) u.getOrDefault("password", null),
                                                    (String) u.getOrDefault("birthday", null),
                                                    (String) u.getOrDefault("phone", null),
                                                    (String) u.getOrDefault("gender",null),
                                                    (String) u.getOrDefault("occupation", null));
            session.setAttribute("currentSessionUser", currentUser);
            String userJsonString = Parser.userToJson(user);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(userJsonString);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("delete user");
            try {
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            if (currentUser instanceof Admin) {
                Integer userID = Integer.parseInt(request.getPathInfo().substring(1));
                System.out.println(userID);

                boolean res = Home4All.blockUser(userID);
                if (!res){
                    throw new Exception("ERRO: Utilizador não encontrado.");
                }
                response.setContentType("application/json"); // multipart/form-data
                response.setCharacterEncoding("UTF-8");
            }
            else{
                boolean res = Home4All.deleteUser(currentUser.getID());
                if (res){
                    response.setContentType("application/json"); // multipart/form-data
                    response.setCharacterEncoding("UTF-8");
                }
                else{
                    throw new Exception("ERRO: Não é possivel eliminar o utilizador");
                }
            }
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND, e.getMessage());
            e.printStackTrace();
        }
    }
}
