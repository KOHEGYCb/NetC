package transport;

/**
 *
 * @author Dmitry
 */
public class Trolleybus extends Transport{
    
    private static int amount;

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
    
    @Override
    public String writeTimetable() {
        return "TROLLEYBUS " + getTimetable().toString();
    }
}
