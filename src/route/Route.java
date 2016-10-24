package route;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import transport.Bus;
import transport.Tram;
import transport.Transport;
import transport.Trolleybus;

/**
 *
 * @author Dmitry
 */
public class Route {

    private Station A;
    private Station B;
    private int typeRoad;
    private int id;
    private List<Transport> transport = new ArrayList<Transport>();

    public Route() {
        ArrStations arrStations = new ArrStations();
        initComp(arrStations);
    }

    public Route(ArrStations arr) {
        initComp(arr);
    }

    public Route(ArrStations arr, int id) {
        initComp(arr);
        this.id = id++;
    }

    private void initComp(ArrStations arrStations) {
        int st1 = new Random().nextInt(arrStations.getStations().size());
        int st2;
        do {
            st2 = new Random().nextInt(arrStations.getStations().size());
        } while (st2 == st1);
        st2 = new Random().nextInt(arrStations.getStations().size());
        this.A = arrStations.getStations().get(st1);
        this.B = arrStations.getStations().get(st2);
        setTypeRoad();
//        setTransport(typeRoad);
    }

    private void setTypeRoad() {
        if (A.getTypeRoad() < B.getTypeRoad() | A.getTypeRoad() == B.getTypeRoad()) {
            this.typeRoad = A.getTypeRoad();
        } else {
            this.typeRoad = B.getTypeRoad();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Route Id: " + id;
    }

    public String routeInfo() {
        String str = "Route ID: " + id + " {\n" + getA().toString() + getB().toString();
//        for (int i = 0; i < this.transport.length; i++) {
//            str = str + this.transport[i].toString() + "\n";
//        }

//        return "Route{\n" + getA().toString() + getB().toString() + '}';
        return str + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.getA());
        hash = 37 * hash + Objects.hashCode(this.getB());
        hash = 37 * hash + this.getId();
        return hash;
    }

    /**
     *
     * @param obj
     * @return
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
        final Route other = (Route) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!Objects.equals(this.A, other.A)) {
            return false;
        }
        if (!Objects.equals(this.B, other.B)) {
            return false;
        }
        return true;
    }

    /**
     * @return the A
     */
    public Station getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(Station A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public Station getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(Station B) {
        this.B = B;
    }

    /**
     * @return the typeRoad
     */
    public int getTypeRoad() {
        return typeRoad;
    }

    /**
     * @param typeRoad the typeRoad to set
     */
    public void setTypeRoad(int typeRoad) {
        this.typeRoad = typeRoad;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public void addTransport() {
        Transport newTransport = null;
        System.out.println("*****");
        int type;
        switch (typeRoad) {
            case 0:
                System.out.println("1) Add Bus");
                newTransport = new Bus();
                break;
            case 1:
                System.out.println(
                        "1) Add Bus\n"
                        + "2) Add Trolleybus");
                try {
                    type = new Scanner(System.in).nextInt();
                    if (type == 1) {
                        newTransport = new Bus();
                    }
                    if (type == 2) {
                        newTransport = new Trolleybus();
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Not integer");
                }
                break;
            case 2:
                System.out.println(
                        "1) Add Bus\n"
                        + "2) Add Trum");
                try {
                    type = new Scanner(System.in).nextInt();
                    if (type == 1) {
                        newTransport = new Bus();
                    }
                    if (type == 2) {
                        newTransport = new Tram();
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Not integer");
                }
                break;
            case 3:
                System.out.println(
                        "1) Add Bus\n"
                        + "2) Add Trolleybus\n"
                        + "3) Add Trum");
                try {
                    type = new Scanner(System.in).nextInt();
                    if (type == 1) {
                        newTransport = new Bus();
                    }
                    if (type == 2) {
                        newTransport = new Trolleybus();
                    }
                    if (type == 3) {
                        newTransport = new Tram();
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Not integer");
                }
                break;
        }
        System.out.println("*****");
        if (newTransport == null) {
            System.out.println("Transport not Add");
            return;
        }
        getTransport().add(newTransport);
        System.out.println("Transport Add");
    }

    public String writeTransportTimetable() {
        String str = "";
        for (int i = 0; i < this.getTransport().size(); i++) {
            str = str + getTransport().get(i).writeTimetable() + "\n";
        }
        return str;
    }

    /**
     * @return the transports
     */
    public List<Transport> getTransport() {
        return transport;
    }

    /**
     * @param transports the transports to set
     */
    public void setTransport(List<Transport> transports) {
        this.transport = transports;
    }

    public void writeTransport() {
        if (transport.isEmpty()) {
            System.out.println("No Transport");
            return;
        }
        ListIterator<Transport> listIterator = transport.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

    public void remuveTransport() {
        writeTransport();
        System.out.println("Write ID: ");
        try {
            int id = new Scanner(System.in).nextInt();
            boolean isFound = false;
            for (int i = 0; i < transport.size(); i++) {
                if (transport.get(i).getId() == id) {
                    transport.remove(i);
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Id not found");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
    }

}
