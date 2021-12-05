package ua.rakhmail.utils;

import ua.rakhmail.dao.HorseDao;

import java.io.*;

public class HibernateChanger {
    public void change() {
        // for create DB we can just load something from DB
        HorseDao horseDao = new HorseDao();
        horseDao.getCountOfHorses();
        HibernateUtil.shutdown();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/codeForHibernateChange"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/hibernate.cfg.xml"))
        ) {
            String text;
            while ((text = reader.readLine()) != null) {
                writer.write(text + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
