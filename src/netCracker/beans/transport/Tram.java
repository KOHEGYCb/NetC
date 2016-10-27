package netCracker.beans.transport;

/**
 *
 * @author Dmitry
 */
public class Tram extends Transport{
    
    private static int amount;

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
    
    /**
     *
     */
    public Tram(){
        super(amount);
        setType(2);
        amount++;
    }
    
    /**
     * 
     * @return the short description of Tram
     */
    @Override
    public String toString() {
        return "Tram{ ID: " + this.getId() + "}";
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String writeTimetable() {
        return "TRAM " + getTimetable().toString();
    }
    
    /**
     *
     * @return
     */
    @Override
    public String writeAll() {
        return "Bus{ ID: " + this.getId() + " Number: " + getNumber() + "}";
    }

    /**
     *
     * @return
     */
    @Override
    public String writeShort() {
        return "Bus{ ID: " + this.getId() + "}";
    }
}
