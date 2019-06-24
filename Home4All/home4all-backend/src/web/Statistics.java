package web;

import business.Home4All;
import com.google.gson.Gson;
import javafx.util.Pair;

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
import java.util.logging.Logger;

@WebServlet(name = "Statistics", urlPatterns = {"/statistics"})
public class Statistics extends HttpServlet {
    private Gson gson = new Gson();
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("GET STATISTICS");
        try {
            HttpSession session = request.getSession(false);
            business.entities.Users currentUser = (business.entities.Users) session.getAttribute("currentSessionUser");
            BufferedReader reader = request.getReader();
            Map dates = gson.fromJson(reader, Map.class);
            String dateBegin = (String) dates.get("dateBegin");
            String dateEnd = (String) dates.get("dateEnd");
            System.out.println(dateBegin);
            System.out.println(dateEnd);
            Map<Date, Long> info1 = new HashMap<>();
            Map<Date, Map.Entry<Long,Long>> info2 = new HashMap<>();
            info2 = Home4All.getStatisticsPropertyAddSold(currentUser.getID(), dateBegin, dateEnd);
            info1 = Home4All.getStatisticsQuantity(currentUser.getID(), dateBegin, dateEnd);
            String jsonResponse = Parser.statisticsToJson(info1,info2);
            response.setContentType("application/json"); // multipart/form-data
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonResponse);
            out.flush();
        }
        catch (Exception e) {
            LOGGER.info("FAILED GET STATISTICS");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.sendError(javax.servlet.http.HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            e.printStackTrace();
        }

    }
}
