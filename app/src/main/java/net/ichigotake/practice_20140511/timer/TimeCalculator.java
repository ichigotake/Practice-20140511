package net.ichigotake.practice_20140511.timer;

import java.util.Random;

public class TimeCalculator {

    public static int generateRandomHour() {
        return Math.abs((new Random().nextInt() * 10) % 24);
    }

    private final Timer timer;

    public TimeCalculator(Timer timer) {
        this.timer = timer;
    }

    public boolean isBetween(int hour) {
        int periodHour;
        int betweenHour;
        if (timer.getStartHour() > hour) {
            betweenHour = hour + 24;
        } else {
            betweenHour = hour;
        }
        if (timer.getStartHour() >= timer.getPeriodHour()) {
            periodHour = timer.getPeriodHour() + 24;
        } else {
            periodHour = timer.getPeriodHour();
        }
        return timer.getStartHour() <= betweenHour && betweenHour < periodHour;
    }

}
