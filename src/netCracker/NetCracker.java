/*
 
Система городской транспорт. На МАРШРУТ назначается Автобус, Tроллейбус или 
Tрамвай. Транспортные средства должны двигаться с определенным для каждого 
маршрута интервалом или рассписанием.

 */
package netCracker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import route.ArrStations;
import route.Route;

/**
 *
 * @author Dmitry
 */
public class NetCracker {

    private static ArrStations arrStations = new ArrStations();
    private static List<Route> routes = new ArrayList<Route>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loopMain();
        arrStations.ser();
    }

    private static void loopMain() {
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

    private static void loopRoute() {
        writeRouteMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    if (arrStations.getStations().size() < 2){
                        System.out.println("Not enough Stations");
                        break;
                    }
                    routes.add(new Route(arrStations, routes.size()));
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

    private static void loopRouteWork(int id) {
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
                    System.out.println(routes.get(id).routeInfo());
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
    
    private static void loopTransport(int id) {
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
                    routes.get(id).addTransport();
                    break;
                case 2:
                    routes.get(id).remuveTransport();
                    break;
                case 3:
                    routes.get(id).writeTransport();
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

    private static void loopStation() {
        writeStationMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    arrStations.addStation();
                    break;
                case 2:
                    if (arrStations.getStations().size() == 0){
                        System.out.println("No Station");
                        break;
                    }
                    arrStations.remuveStation();
                    break;
                case 3:
                    System.out.println(arrStations);
                    break;
                case 4:
                    arrStations.renameStation();
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

    private static void writeMenu() {
        System.out.print("*****\n"
                + "1) Work with Route\n"
                + "2) Work whis Station\n"
                + "0) Exit\n*****\n"
                + "Write point: ");
    }

    private static void writeRouteMenu() {
        System.out.print("*****\n"
                + "1) Add Route\n"
                + "2) Remuve Route\n"
                + "3) Work with Route\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    private static void writeRouteWorkMenu() {
        System.out.print("*****\n"
                + "1) Write Route\n"
                + "2) Work with Transport\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    private static void writeTransportMenu() {
        System.out.print("*****\n"
                + "1) Add Transport\n"
                + "2) Remuve Transport\n"
                + "3) Write Transport\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    private static void writeStationMenu() {
        System.out.print("*****\n"
                + "1) Add Station\n"
                + "2) Remuve Station\n"
                + "3) Write Stations\n"
                + "4) Rename Station\n"
                + "0) Back\n*****\n"
                + "Write point: ");
    }

    private static void remuveRoute() {
        int id = chooseRouteId();
        if (id == -1) {
            System.out.println("Route not remuved\n*****");
            return;
        }
        routes.remove(id);
        for (int j = id; j < routes.size(); j++) {
            routes.get(j).setId(j);
        }
        System.out.println("Route remuved");
    }

    private static void writeRoute() {
        ListIterator<Route> listIterator = routes.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }

    private static int chooseRouteId() {
        if (routes.isEmpty()) {
            System.out.println("No route");
            return -1;
        }
        if (routes.size() == 1) {
            return 0;
        }
        System.out.println("*****\nRoute List");
        writeRoute();
        System.out.print("Choose id: ");
        try {
            int id = new Scanner(System.in).nextInt();
            boolean find = false;
            for (int i = 0; i < routes.size(); i++) {
                if (routes.get(i).getId() == id) {
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
}
