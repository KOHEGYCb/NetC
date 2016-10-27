package netCracker.beans.transport;

/**
 *
 * @author Dmitry
 */
public class Bus extends Transport {

    private static int amount = 0;

    /**
     * @param aAmount the amount to set
     */
    public static void setAmount(int aAmount) {
        amount = aAmount;
    }

    /**
     *
     */
    public Bus() {
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
        return "Bus{ ID: " + this.getId() + "}";
    }

    /**
     *
     * @return
     */
    @Override
    public String writeTimetable() {
        return "BUS " + getTimetable().toString();
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
