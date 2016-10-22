package timetable;

/**
 *
 * @author Dmitry
 */
public class Timetable {

    private Weekdays weekdays;
    private DayPart dayPart;
    private int interval[][];

    public Timetable() {
        interval = new int[7][5];
        for (Weekdays wd : Weekdays.values()) {
            for (DayPart dp : DayPart.values()) {
                switch (dp) {
                    case MORNING:
                        this.interval[wd.getIndex() - 1][dp.getIndex() - 1] = 10;
                        break;
                    case AFTERNOON:
                        this.interval[wd.getIndex() - 1][dp.getIndex() - 1] = 20;
                        break;
                    case EVENING:
                        this.interval[wd.getIndex() - 1][dp.getIndex() - 1] = 15;
                        break;
                    case LATEEVENING:
                        this.interval[wd.getIndex() - 1][dp.getIndex() - 1] = 30;
                        break;
                    case NIGHT:
                        this.interval[wd.getIndex() - 1][dp.getIndex() - 1] = -1;
                        break;
                }
                if (wd == Weekdays.SUNDAY | wd == Weekdays.SATURDAY) {
                    this.interval[wd.getIndex() - 1][dp.getIndex() - 1] = 15;
                }
            }
        }
    }

//    public Timetable(Weekdays weekdays, DayPart dayPart) {
//        this.weekdays = weekdays;
//        this.dayPart = dayPart;
//
//    }

    @Override
    public String toString() {
        String str = "Timetable{\n";
        for (Weekdays wd : Weekdays.values()) {
            str = str + " weekdays: " + wd + "\n";
            for (DayPart dp : DayPart.values()) {
                str = str + "  dayPart: " + dp + " intterval: " + this.getInterval(wd.getIndex() - 1, dp.getIndex() - 1) + "\n";
            }
            str = str + "\n";
        }
        return str + "}";
    }

    public String toString(Weekdays weekdays) {
        String str = "Timetable{" + "weekdays=" + weekdays + "\n";
        for (DayPart dp : DayPart.values()) {
            str = str + " dayPart: " + dp + " intterval: " + this.getInterval(weekdays.getIndex() - 1, dp.getIndex() - 1) + "\n";
        }

        return str + "}";
    }

//    public Timetable getTimetable(){
//        
//    }
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
