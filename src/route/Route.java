package route;

import java.util.ArrayList;
import java.util.List;
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
//    private Transport[] transport;
    private List<Transport> transport = new ArrayList<Transport>();

    public Route() {
        ArrStations arrStations = new ArrStations();
        initComp(arrStations);
//        transport.add(new Bus());
    }

    public Route(ArrStations arr) {
        initComp(arr);
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
        id = Integer.parseInt("" + A.getId() + B.getId());
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
        String str = "Route{\n" + getA().toString() + getB().toString();
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

//    /**
//     * @return the transport
//     */
//    public Transport[] getTransport() {
//        return transport;
//    }

    public void addTransport() {
        System.out.println("*****");
        switch (typeRoad) {
            case 0:
                /*add bus*/
                System.out.println("1) Add Bus");
                break;
            case 1:
                /*add bus trolleybus*/
                System.out.println(
                          "1) Add Bus\n"
                        + "2) Add Trolleybus");
                break;
            case 2:
                /*add bus tram*/
                System.out.println(
                          "1) Add Bus\n"
                        + "2) Add Trum");
                break;
            case 3:
                /*add all*/
                System.out.println(
                          "1) Add Bus\n"
                        + "2) Add Trolleybus\n"
                        + "3) Add Trum");
                break;
        }
        System.out.println("*****");
        
        int n = new Scanner(System.in).nextInt();
        int number;
        switch(n){
            case 1:
                System.out.print("Set number: ");
                number = new Scanner(System.in).nextInt();
                getTransport().add(new Bus());
                break;
            case 2:
                System.out.print("Set number: ");
                number = new Scanner(System.in).nextInt();
                getTransport().add(new Trolleybus());
                break;
            case 3:
                System.out.print("Set number: ");
                number = new Scanner(System.in).nextInt();
                getTransport().add(new Tram());
                break;
        }
        
    }

//    /**
//     * @param transport the transport to set
//     */
//    public void setTransport(Transport[] transport) {
//        this.transport = transport;
//    }

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

}
