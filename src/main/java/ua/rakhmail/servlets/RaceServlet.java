package ua.rakhmail.servlets;

import ua.rakhmail.dao.HorseDao;
import ua.rakhmail.dao.RaceDao;
import ua.rakhmail.entity.Horse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RaceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        userInfo.getUserInfo().forEach((key, value) -> {
//            if (value.equals(req.getHeader("user-agent")) && key.equals(req.getRemoteAddr())) {
//                responseBody.println("<main align=\"center\"><b>Request from: " + "IP: " + key + ", Browser: " + value + "</b></main>");
//            } else {
//                responseBody.println("<main align=\"center\">Request from: " + "IP: " + key + ", Browser: " + value + "</main>");
//            }
//        });
//
//        String client = req.getParameter("client");
//        if (client == null) {
//            client = "Anonymous";
//        }
//        responseBody.println("<h3 align=\"center\">Hello, " + client + " </h3>");
//        responseBody.println("<h3 align=\"center\"><a href=\"http://localhost:8080\"><-- you can tap here for BACK</a></h3>");


//        HorseDao horseDao = new HorseDao();
//
//        System.out.println(System.lineSeparator());
//        // в race сервлет по id
//        List<Horse> horsesByRaceId = horseDao.getAllHorseByRaceId(1);
//        if (!(horsesByRaceId.isEmpty())) {
//            assert false;
//            System.out.println("Date of starting race: " + horsesByRaceId.get(0).getRace().getDate());
//            System.out.println("Number of horses: " + horsesByRaceId.size());
//
//            horsesByRaceId.forEach(x -> {
//                if (x.isChosen()) {
//                    System.out.println("BIG CHOSE " + x.getName() + " come in " + x.getPlace() + " place.");
//                } else {
//                    System.out.println(x.getName() + " come in " + x.getPlace() + " place.");
//                }
//            });
//        } else {
//            System.out.println("ERROR race not found ERROR");
//        }


    }
}