package timetable;

/**
 *
 * @author Dmitry
 */
public enum DayPart {
    MORNING(1, 6, 10),
    AFTERNOON(2, 10, 16),
    EVENING(3, 16, 21),
    LATEEVENING(4, 21, 1),
    NIGHT(5, 1, 6);
    
    private int index;
    private int start;
    private int stop;

    DayPart(int index, int start, int stop) {
        this.index = index;
        this.start = start;
        this.stop = stop;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @return the stop
     */
    public int getStop() {
        return stop;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }
   
}
