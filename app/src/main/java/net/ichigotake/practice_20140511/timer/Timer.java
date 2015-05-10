package net.ichigotake.practice_20140511.timer;

public class Timer {

    private final int startHour;
    private final int periodHour;

    public Timer(int startHour, int periodHour) {
        this.startHour = startHour;
        this.periodHour = periodHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getPeriodHour() {
        return periodHour;
    }

}
