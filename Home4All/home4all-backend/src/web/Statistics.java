package web;

import business.Home4All;
import business.Parser;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Statistics", urlPatterns = {"/statistics"})
public class Statistics extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            BufferedReader reader = request.getReader();
            Map dates = gson.fromJson(request.getParameter("payload"), Map.class);
            //Map dates = gson.fromJson(reader, Map.class);
            String dateBegin = (String) dates.get("dateBegin");
            String dateEnd = (String) dates.get("dateEnd");
            Map<Date, Long> info1 = new HashMap<>();
            Map<String, Map.Entry<Long,Long>> info2 = new HashMap<>();
            info1 = Home4All.getStatisticsQuantity(currentUser.getID(), dateBegin, dateEnd);
            info2 = Home4All.getStatisticsPropertyAddSold(currentUser.getID(), dateBegin, dateEnd);
            String jsonResponse = Parser.statisticsToJson(info1,info2);
            response.setContentType("application/json"); // multipart/form-data
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonResponse);
            out.flush();
        }
        catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }

    }
}
