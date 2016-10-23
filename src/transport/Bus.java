package transport;

/**
 *
 * @author Dmitry
 */
public class Bus extends Transport{

    private static int amount = 0;

    public Bus(){
        super(amount);
        setType(0);
        amount++;
    }
    
    /**
     * @return the amount of Bus
     */
    public static int getAmount() {
        return amount;
    }
    
    /**
     * 
     * @return the short description of Bus
     */
    @Override
    public String toString() {
        return "Bus{ ID: " + this.getId() + " Number: " + getNumber() +"}";
    }

    @Override
    public String writeTimetable() {
        return "BUS " + getTimetable().toString();
    }
    
    
    
}
