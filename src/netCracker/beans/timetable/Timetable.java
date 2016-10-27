package netCracker.beans.timetable;

import netCracker.enums.Weekdays;
import netCracker.enums.DayPart;
import netCracker.utils.IOTimetable;

/**
 *
 * @author Dmitry
 */
public class Timetable {

    private Weekdays weekdays;
    private DayPart dayPart;
    private int interval[][];
    /**
     *
     */
    public Timetable() {
        interval = new int[7][5];
        for (Weekdays weekday : Weekdays.values()) {
            for (DayPart dayPart : DayPart.values()) {
                switch (dayPart) {
                    case MORNING:
                        this.interval[weekday.getIndex() - 1][dayPart.getIndex() - 1] = 10;
                        break;
                    case AFTERNOON:
                        this.interval[weekday.getIndex() - 1][dayPart.getIndex() - 1] = 20;
                        break;
                    case EVENING:
                        this.interval[weekday.getIndex() - 1][dayPart.getIndex() - 1] = 15;
                        break;
                    case LATEEVENING:
                        this.interval[weekday.getIndex() - 1][dayPart.getIndex() - 1] = 30;
                        break;
                    case NIGHT:
                        this.interval[weekday.getIndex() - 1][dayPart.getIndex() - 1] = 60;
                        break;
                }
                if (weekday == Weekdays.SUNDAY | weekday == Weekdays.SATURDAY) {
                    this.interval[weekday.getIndex() - 1][dayPart.getIndex() - 1] = 15;
                }
            }
        }
    }

    public void outputFile(){
        new IOTimetable().outputTimetable(toString());
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return new IOTimetable().inputTimetable();
    }

    /**
     *
     * @param weekdays
     * @return
     */
    public String toString(Weekdays weekdays) {
        String str = "Timetable{" + "weekdays=" + weekdays + "\n";
        for (DayPart dayPart : DayPart.values()) {
            str = str + " dayPart: " + dayPart + " intterval: " + this.getInterval(weekdays.getIndex() - 1, dayPart.getIndex() - 1) + "\n";
        }

        return str + "}";
    }

    /**
     *
     * @return
     */
    private String makeString() {
        String str = "";

        return str;
    }

    /**
     * @return the weekdays
     */
    public Weekdays getWeekdays() {
        return weekdays;
    }

    /**
     * @return the dayPart
     */
    public DayPart getDayPart() {
        return dayPart;
    }

    /**
     * @return the interval
     */
    public int[][] getInterval() {
        return interval;
    }

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public int getInterval(int i, int j) {
        return interval[i][j];
    }

    /**
     * @param weekdays the weekdays to set
     */
    public void setWeekdays(Weekdays weekdays) {
        this.weekdays = weekdays;
    }

    /**
     * @param dayPart the dayPart to set
     */
    public void setDayPart(DayPart dayPart) {
        this.dayPart = dayPart;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(int[][] interval) {
        this.interval = interval;
    }
}
