package ua.rakhmail.servlets;

import ua.rakhmail.entity.hippodrome.SaveEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StartRaceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String horseStr = req.getParameter("horses");
        String choseStr = req.getParameter("chose");

        PrintWriter responseBody = resp.getWriter();

        resp.setContentType("text/html");

        int horseInt;
        int choseInt;

        try {
            horseInt = Integer.parseInt(horseStr);
            choseInt = Integer.parseInt(choseStr);
            if ((horseInt > 0 && horseInt < Integer.MAX_VALUE) && (choseInt <= horseInt)) {
                SaveEntity saveEntity = new SaveEntity();
                saveEntity.addNewRace(horseInt, choseInt);
                responseBody.println("<h3>Race is start and save in DB, you can look it in" +
                        " <a href=\"http://localhost:8080/stats\">Statistic</a></h3>\n");
                responseBody.println("<h3>or <a href=\"http://localhost:8080/form.jsp\">Start one more new race</a></h3>\n");
            } else {
                responseBody.println("<h3>Please, enter only positive numbers and in the selection of a horse, </h3>");
                responseBody.println("<h3>the number is not more than the specified number of horses.</h3>\n");
                responseBody.println("<h3><a href=\"http://localhost:8080/form.jsp\">TRY AGAIN</a></h3></h3>");
            }
        } catch (Exception e) {
            responseBody.println("<h3>Please, enter only positive numbers and in the selection of a horse, </h3>");
            responseBody.println("<h3>the number is not more than the specified number of horses.</h3>\n");
            responseBody.println("<h3><a href=\"http://localhost:8080/form.jsp\">TRY AGAIN</a></h3></h3>");
        }
    }


}
