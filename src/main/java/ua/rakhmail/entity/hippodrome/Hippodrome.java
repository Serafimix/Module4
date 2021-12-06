package ua.rakhmail.entity.hippodrome;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Hippodrome {
    private static List<HorseThread> list = new ArrayList<>();
    private boolean isEnd = true;

    @SneakyThrows
    public void startRace(int horseses, int chose) {
        HorseThread horseThread;
        for (int i = 1; i <= horseses; i++) {
            horseThread = new HorseThread();
            horseThread.setName("Horse#" + i);
            list.add(horseThread);
        }
        list.forEach(Thread::start);

        while (true) {
            if (list.stream().noneMatch(Thread::isAlive)) {
                Optional<HorseThread> youHorse;
                youHorse = list.stream().filter(x -> x.getNumber() == chose).findFirst();
                while (youHorse.get().getPlaceInRace() == 0) {
                    Thread.sleep(100);
                }
                HorseThread.setCount(1);
                this.isEnd = false;
                break;
            } else {
                Thread.sleep(100);
            }
        }
    }

    public static List<HorseThread> getList() {
        return list;
    }
}
