package ua.rakhmail.entity.hippodrome;

import ua.rakhmail.dao.HorseDao;
import ua.rakhmail.dao.RaceDao;
import ua.rakhmail.entity.Horse;
import ua.rakhmail.entity.Race;

import java.util.ArrayList;
import java.util.List;

public class SaveEntity {

    public void addNewRace(int horse, int chose) {
        HorseDao horseDao = new HorseDao();
        RaceDao raceDao = new RaceDao();
        List<Horse> horses = new ArrayList<>();
        Hippodrome hippodrome = new Hippodrome();

        Race race = new Race();
        raceDao.create(race);

        hippodrome.startRace(horse, chose);
        hippodrome.getList().forEach(x -> {
            if (x.getNumber() == chose) {
                horses.add(new Horse(x.getName(), x.getPlaceInRace(), true, race));

            } else {
                horses.add(new Horse(x.getName(), x.getPlaceInRace(), false, race));
            }
        });
        race.setHorses(horses);

        horses.forEach(horseDao::create);
        hippodrome.getList().clear();
        HorseThread.placeCount.set(0);
    }
}
