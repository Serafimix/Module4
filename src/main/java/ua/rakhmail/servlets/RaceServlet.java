package ua.rakhmail.servlets;

import ua.rakhmail.dao.HorseDao;
import ua.rakhmail.dao.RaceDao;
import ua.rakhmail.entity.Horse;
import ua.rakhmail.entity.Race;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceServlet extends HttpServlet {
    private static final HorseDao horseDao = new HorseDao();
    private static final RaceDao raceDao = new RaceDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        List<Horse> horsesByRaceId;
        responseBody.println("<h1><a href=\\>Back to localhost</a></h1>");
        responseBody.println("<h1 align=\"center\">There is a race vision.</h1>");
        responseBody.println("<h2 align=\"center\">You can add to the site" +
                " address \"?id=*race number*\" for looking the race.</h2>");

        String chosenRaceStr = req.getParameter("id");
        int chosenRace;
        try {
            chosenRace = Integer.parseInt(chosenRaceStr);
            if (chosenRace > 0 && chosenRace <= raceDao.getCountOfRace()) {
                horsesByRaceId = horseDao.getAllHorseByRaceId(chosenRace);

                // выводит ьсписок решил в отсортированном, по месту финиша, виде

                List<Horse> horses = horsesByRaceId.stream()
                        .sorted(Comparator.comparingInt(Horse::getPlace))
                        .collect(Collectors.toList());
                Race race = raceDao.getById(chosenRace);

                responseBody.println("<h2>Date of the race #" + chosenRace + ":  " + race.getDate() + "</h2>\n");
                responseBody.println("<h2>Summary horses in the race: " + horses.size() + "</h2>\n");

                responseBody.println("<table border=\"1\"><tr><th>Horse name</th><th>Place</th></tr>");
                for (var h : horses) {
                    if (h.isChosen()) {
                        responseBody.println("<tr><th>" + h.getName() + "</th><th>" + h.getPlace() + "</th></tr");
                    } else {
                        responseBody.println("<tr><td>" + h.getName() + "</td><td>" + h.getPlace() + "</td></tr");
                    }
                }
                responseBody.println("<table>");
            } else {
                responseBody.println("<h3 align=\"center\">Please, enter only positive numbers is" +
                        " not more than " + raceDao.getCountOfRace() + " included</h3>");
                responseBody.println("<h3 align=\"center\"><a href=\"http://localhost:8080/race\">You can try again</a></h3>");
            }
        } catch (Exception e) {
            responseBody.println("<h3 align=\"center\">Please, enter only positive numbers is" +
                    " not more than " + raceDao.getCountOfRace() + " included</h3>");
            responseBody.println("<h3 align=\"center\"><a href=\"http://localhost:8080/race\">You can try again</a></h3>");
        }
    }
}
