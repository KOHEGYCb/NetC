package transport;

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
    
    public Tram(){
        super();
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
    @Override
    public String writeTimetable() {
        return "TRAM " + getTimetable().toString();
    }
}
