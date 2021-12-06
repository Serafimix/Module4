package ua.rakhmail.servlets;


import ua.rakhmail.dao.HorseDao;
import ua.rakhmail.dao.RaceDao;
import ua.rakhmail.entity.Horse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StatsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HorseDao horseDao = new HorseDao();
        RaceDao raceDao = new RaceDao();
        List<Horse> chosenHorses = horseDao.getChosenHorses();

        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        responseBody.println("<h1><a href=\\>Back to localhost</a></h1>");
        responseBody.println("<h1 align=\"center\">There is a statistic of races and place of the chosen horse </h1>");

        responseBody.println("<h2>Summary of races is: " + raceDao.getCountOfRace() + "</h2>\n");
        responseBody.println("<h2>Summary of horses running is: " + horseDao.getCountOfHorses() + "</h2>\n");

        responseBody.println("<table border=\"1\"><tr><th>Race #</th>" +
                "<th>Chosen horse</th><th>Place</th><th>Total number horse in race</th></tr>");
        for (var h : chosenHorses) {

            responseBody.println("<tr><th>" + h.getRace().getId() + "</th>" +
                    "<th>" + h.getName() + "</th><th>" + h.getPlace() + "</th><th>" +
                    horseDao.getCountOfHorsesByIdRace(h.getRace().getId()) + "</th></tr");
        }
        responseBody.println("<table>");

    }
}
