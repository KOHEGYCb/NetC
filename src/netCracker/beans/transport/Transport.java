package netCracker.beans.transport;

import netCracker.beans.timetable.Timetable;
import netCracker.interfaces.Writer;

/**
 *
 * @author Dmitry
 */
public abstract class Transport implements Writer{
    
    private static int amount = 0;

    /**
     * @return the amount
     */
    public static int getAmount() {
        return amount;
    }

    /**
     * @param aAmount the amount to set
     */
    public static void setAmount(int aAmount) {
        amount = aAmount;
    }
    private int id;
    private Timetable timetable; 
    private int number;
    private int type;

    /**
     *
     * @param number
     */
    public Transport(int number) {
        timetable = new Timetable();
        this.number = number;
        type = -1;
        id = amount;
        amount++;
    }

    /**
     * @return the id of some Transport
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set new Transport id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return a hashCode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        return hash;
    }

    /**
     *
     * @param obj which will be compared
     * @return the comparison result
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transport other = (Transport) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * @return the timetable
     */
    public Timetable getTimetable() {
        return timetable;
    }

    /**
     * @param timetable the timetable to set
     */
    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    /**
     *
     * @return 
     */
    public String writeTimetable() {
        return "Transport";
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public abstract String writeAll();

    @Override
    public abstract String writeShort();
    
    
}

