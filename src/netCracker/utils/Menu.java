package netCracker.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import netCracker.beans.route.Route;
import netCracker.beans.route.Station;
import netCracker.beans.timetable.Timetable;

/**
 *
 * @author Dmitry
 */
public class Menu {

    private List<Station> stations = (List<Station>) new ArrStations().deser();
    private List<Route> routes = new ArrayList<Route>();

    /**
     *
     */
    public Menu() {
        loopMain();
        new ArrStations().ser(stations);
    }

    /**
     *
     */
    private void loopMain() {
        writeMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    loopRoute();
                    break;
                case 2:
                    loopStation();
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
        loopMain();
    }

    /**
     *
     */
    private void loopRoute() {
        writeRouteMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    if (getStations().size() < 2) {
                        System.out.println("Not enough Stations");
                        break;
                    }
                    getRoutes().add(new Route(getStations(), getRoutes().size()));
                    System.out.println("Route created");
                    writeRoute();
                    break;
                case 2:
                    remuveRoute();
                    writeRoute();
                    break;
                case 3:
                    loopRouteWork(chooseRouteId());
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
        loopRoute();
    }

    /**
     *
     * @param id
     */
    private void loopRouteWork(int id) {
        if (id == -1) {
            return;
        }
        writeRouteWorkMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    System.out.println(getRoutes().get(id).routeInfo());
                    break;
                case 2:
                    loopTransport(id);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
        loopRouteWork(id);
    }

    /**
     *
     * @param id
     */
    private void loopTransport(int id) {
        if (id == -1) {
            return;
        }
        writeTransportMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    getRoutes().get(id).addTransport();
                    for (int i = 0; i < getRoutes().get(id).getTransport().size(); i++) {
                        System.out.println(getRoutes().get(id).getTransport().get(i).writeShort());
                    }
                    break;
                case 2:
                    if (getRoutes().get(id).getTransport().isEmpty()){
                        System.out.println("No transport");
                        break;
                    }
                    getRoutes().get(id).remuveTransport();
                    for (int i = 0; i < getRoutes().get(id).getTransport().size(); i++) {
                        System.out.println(getRoutes().get(id).getTransport().get(i).writeShort());
                    }
                    break;
                case 3:
                    getRoutes().get(id).writeTransport();
                    break;
                case 4:
                    if (getRoutes().get(id).getTransport().isEmpty()) {
                        System.out.println("No transport");
                        break;
                    }
                    System.out.println(new Timetable());
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
        loopTransport(id);
    }

    /**
     *
     */
    private void loopStation() {
        writeStationMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    System.out.println(new ArrStations().writeShort(stations));
                    setStations(new ArrStations().addStation(getStations()));
                    System.out.println(new ArrStations().writeShort(stations));
                    break;
                case 2:
                    if (getStations().isEmpty()) {
                        System.out.println("No Station");
                        break;
                    }
                    System.out.println(new ArrStations().writeShort(stations));
                    setStations(new ArrStations().remuveStation(getStations()));
                    System.out.println(new ArrStations().writeShort(stations));
                    break;
                case 3:
                    System.out.println(new ArrStations().toString(getStations()));
                    break;
                case 4:
                    System.out.println(new ArrStations().writeShort(stations));
                    setStations(new ArrStations().renameStation(getStations()));
                    System.out.println(new ArrStations().writeShort(stations));
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
        loopStation();
    }

    /**
     *
     */
    private void writeMenu() {
        System.out.print("***** Main *****\n"
                + "1) Work with Routes\n"
                + "2) Work whis Station\n"
                + "0) Exit\n****************\n"
                + "Write point: ");
    }

    /**
     *
     */
    private void writeRouteMenu() {
        System.out.print("***** Work with Routes *****\n"
                + "1) Add Route\n"
                + "2) Remuve Route\n"
                + "3) Work with Route\n"
                + "0) Back\n****************************\n"
                + "Write point: ");
    }

    /**
     *
     */
    private void writeRouteWorkMenu() {
        System.out.print("***** Work with Route *****\n"
                + "1) Print Route\n"
                + "2) Work with Transport\n"
                + "0) Back\n***************************\n"
                + "Write point: ");
    }

    /**
     *
     */
    private void writeTransportMenu() {
        System.out.print("***** Work with Transport *****\n"
                + "1) Add Transport\n"
                + "2) Remuve Transport\n"
                + "3) Print Transport\n"
                + "4) Print Timetable\n"
                + "0) Back\n*******************************\n"
                + "Write point: ");
    }

    /**
     *
     */
    private void writeStationMenu() {
        System.out.print("***** Work whis Station *****\n"
                + "1) Add Station\n"
                + "2) Remuve Station\n"
                + "3) Print Stations\n"
                + "4) Rename Station\n"
                + "0) Back\n*****************************\n"
                + "Write point: ");
    }

    /**
     *
     */
    private void remuveRoute() {
        int id = chooseRouteId();
        if (id == -1) {
            System.out.println("Route not remuved\n*****");
            return;
        }
        getRoutes().remove(id);
        /* on/off recalculation id */
//        for (int j = id; j < getRoutes().size(); j++) {
//            getRoutes().get(j).setId(j);
//        }
        System.out.println("Route remuved");
    }

    /**
     *
     */
    private void writeRoute() {
        System.out.println("*****\nRoute List:");
        if (routes.isEmpty()) {
            System.out.println("  No Route");
        }
        ListIterator<Route> listIterator = getRoutes().listIterator();
        while (listIterator.hasNext()) {
            System.out.println("  " + listIterator.next());
        }
    }

    /**
     *
     * @return
     */
    private int chooseRouteId() {
        if (getRoutes().isEmpty()) {
            System.out.println("No route");
            return -1;
        }
        if (getRoutes().size() == 1) {
            return 0;
        }
        System.out.println("*****\nRoute List");
        writeRoute();
        System.out.print("Choose id: ");
        try {
            int id = new Scanner(System.in).nextInt();
            boolean find = false;
            for (int i = 0; i < getRoutes().size(); i++) {
                if (getRoutes().get(i).getId() == id) {
                    find = true;
                    return i;
                }
            }
            if (!find) {
                System.out.println("Route not found\n*****");
                return -1;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer\n*****");
            return -1;
        }
        return -1;
    }

    /**
     * @return the routes
     */
    public List<Route> getRoutes() {
        return routes;
    }

    /**
     * @param routes the routes to set
     */
    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    /**
     * @return the stations
     */
    public List<Station> getStations() {
        return stations;
    }

    /**
     * @param stations the stations to set
     */
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
