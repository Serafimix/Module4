package ua.rakhmail.entity.hippodrome;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class HorseThread extends Thread {
    private static int count = 1;
    private final int number;
    private int distance;
    private volatile int placeInRace;
    static final AtomicInteger placeCount = new AtomicInteger(0);

    public static void setCount(int count) {
        HorseThread.count = count;
    }

    public HorseThread() {
        number = count++;
    }


    @SneakyThrows
    @Override
    public void run() {
        while (distance < 1000) {
            distance = distance + ThreadLocalRandom.current().nextInt(100, 200);
            Thread.sleep(ThreadLocalRandom.current().nextLong(400, 500));
        }
        placeInRace = placeCount.addAndGet(1);
    }

}
