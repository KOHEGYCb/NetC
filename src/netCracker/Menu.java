package netCracker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import route.ArrStations;
import route.Route;
import timetable.Timetable;

/**
 *
 * @author oymer
 */
public class Menu {
    
    private ArrStations arrStations = new ArrStations();
    private List<Route> routes = new ArrayList<Route>();
    
    /**
     * 
     */
    public Menu(){
        loopMain();
        arrStations.ser();
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
                    if (getArrStations().getStations().size() < 2) {
                        System.out.println("Not enough Stations");
                        break;
                    }
                    getRoutes().add(new Route(getArrStations(), getRoutes().size()));
                    System.out.println("Route created");
                    break;
                case 2:
                    remuveRoute();
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
                    break;
                case 2:
                    getRoutes().get(id).remuveTransport();
                    break;
                case 3:
                    getRoutes().get(id).writeTransport();
                    break;
                case 4:
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
                    getArrStations().addStation();
                    break;
                case 2:
                    if (getArrStations().getStations().size() == 0) {
                        System.out.println("No Station");
                        break;
                    }
                    getArrStations().remuveStation();
                    break;
                case 3:
                    System.out.println(getArrStations());
                    break;
                case 4:
                    getArrStations().renameStation();
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
        System.out.print("*****\n"
                + "1) Work with Route\n"
                + "2) Work whis Station\n"
                + "0) Exit\n*****\n"
                + "Write point: ");
    }
    
    /**
     * 
     */
    private void writeRouteMenu() {
        System.out.print("*****\n"
                + "1) Add Route\n"
                + "2) Remuve Route\n"
                + "3) Work with Route\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    /**
     * 
     */
    private void writeRouteWorkMenu() {
        System.out.print("*****\n"
                + "1) Write Route\n"
                + "2) Work with Transport\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    /**
     * 
     */
    private void writeTransportMenu() {
        System.out.print("*****\n"
                + "1) Add Transport\n"
                + "2) Remuve Transport\n"
                + "3) Write Transport\n"
                + "4) Write Timetable\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    /**
     * 
     */
    private void writeStationMenu() {
        System.out.print("*****\n"
                + "1) Add Station\n"
                + "2) Remuve Station\n"
                + "3) Write Stations\n"
                + "4) Rename Station\n"
                + "0) Back\n*****\n"
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
        for (int j = id; j < getRoutes().size(); j++) {
            getRoutes().get(j).setId(j);
        }
        System.out.println("Route remuved");
    }

    /**
     * 
     */
    private void writeRoute() {
        ListIterator<Route> listIterator = getRoutes().listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
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
     * @return the arrStations
     */
    public ArrStations getArrStations() {
        return arrStations;
    }

    /**
     * @param arrStations the arrStations to set
     */
    public void setArrStations(ArrStations arrStations) {
        this.arrStations = arrStations;
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
}
