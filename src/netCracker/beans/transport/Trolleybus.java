package netCracker.beans.transport;


/**
 *
 * @author Dmitry
 */
public class Trolleybus extends Transport{
    
    private static int amount;

    /**
     *
     */
    public Trolleybus(){
        super(amount);
        setType(1);
        amount++;
    }
    
    /**
     * @return the amount
     */
    public static int getAmount() {
        return amount;
    }
    
   /**
     * 
     * @return the short description of Trolleybus
     */
    @Override
    public String toString() {
        return "Trolleybus{ ID: " + this.getId() + "}";
    } 
    
    /**
     *
     * @return
     */
    @Override
    public String writeTimetable() {
        return "TROLLEYBUS " + getTimetable().toString();
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
