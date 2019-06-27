package web;

import business.Home4All;
import business.Parser;
import business.entities.Admin;
import business.entities.Complaint;
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
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(name = "Complaints", urlPatterns = {"/complaints"})
public class Complaints  extends HttpServlet {
    private Gson gson = new Gson();
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            // Um user denuncia um imovel
            BufferedReader reader = request.getReader();
            Map c = gson.fromJson(reader, Map.class);
            Complaint complaint = Home4All.insertComplaint((String) c.get("description"),
                                                            (String) c.get("propertyID"));
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND);
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("GET COMPLAINTS");
        try{
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            if (currentUser instanceof Admin) {
                List<Map<String,Object>> complains = Home4All.getComplaints();
                String complainsData = Parser.complainsToJson(complains);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print(complainsData);
                out.flush();
        }
        else{
            throw new Exception("ERRO: Não tem permissões de acesso.");
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
