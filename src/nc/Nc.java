/*
 
Система городской транспорт. На МАРШРУТ назначается Автобус, Tроллейбус или 
Tрамвай. Транспортные средства должны двигаться с определенным для каждого 
маршрута интервалом или рассписанием.

 */
package nc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import route.ArrStations;
import route.Route;

/**
 *
 * @author Dmitry
 */
public class Nc {

    private static ArrStations arrStations = new ArrStations();
    private static List<Route> routes = new ArrayList<Route>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        loopMain();

//        ArrStations arrStations = new ArrStations();
//        Route route = null;
//
//        writeMenu();
//        Scanner in = new Scanner(System.in);
//        Scanner inMenu = new Scanner(System.in);
//        int menu = -1;
//        int getMenu;
//        try {
//            menu = inMenu.nextInt();
//            getMenu = menu;
//        } catch (InputMismatchException ime) {
//            System.out.println("Error type input data");
//            getMenu = 0;
//        }
//        while (menu != 0) {
//            inMenu = new Scanner(System.in);
//            switch (getMenu) {
//                case 0:
//                    writeMenu();
//                    break;
//                case 1:
//                    if (!routeGen) {
//                        route = new Route();
//                        System.out.println(route);
//                        routeGen = true;
//                        writeMenu();
//                        break;
//                    } else {
//                        writeRouteMenu();
//                        menu = inMenu.nextInt();
//                        switch (menu) {
//                            case 1:
//                                System.out.println(route);
//                                break;
//                            case 2:
//                                System.out.println(route.writeTransportTimetable());
//                                break;
//                            case 3:
//                                route = new Route();
//                                System.out.println(route);
//                                break;
//                            case 4:
//                                route.addTransport();
//                                break;
//                            case 5:
//                                break;
//                            default:
//                                break;
//                        }
//                        writeMenu();
//                        break;
//                    }
//                case 2:
//                    try {
//                        System.out.print("Id: ");
//                        int id = in.nextInt();
//                        System.out.print("Name: ");
//                        String name = in.next();
//                        arrStations.getStations().add(new Station(id, name));
//                    } catch (InputMismatchException ime) {
//                        System.out.println("Error type input data");
//                    }
//                    writeMenu();
//                    break;
//                case 3:
//                    for (int i = 0; i < arrStations.getStations().size(); i++) {
//                        System.out.println(arrStations.getStations().get(i));
//                    }
//                    System.out.print("Choose station id: ");
//                    try {
//                        int id = in.nextInt();
//                        boolean remuve = false;
//                        for (int i = 0; i < arrStations.getStations().size(); i++) {
//                            if (arrStations.getStations().get(i).getId() == id) {
//                                arrStations.getStations().remove(i);
//                                remuve = true;
//                            }
//                        }
//
//                        if (!remuve) {
//                            System.out.println("Station not found");
//                        }
//                    } catch (InputMismatchException ime) {
//                        System.out.println("Error type input data");
//                    }
//                    writeMenu();
//                    break;
//                case 4:
//                    for (int i = 0; i < arrStations.getStations().size(); i++) {
//                        System.out.println(arrStations.getStations().get(i));
//                    }
//                    writeMenu();
//                    break;
//                default:
//                    System.out.println("wrong number");
//                    writeMenu();
//                    break;
//            }
//            try {
//                menu = inMenu.nextInt();
//                getMenu = menu;
//            } catch (InputMismatchException ime) {
//                System.out.println("Error type input data");
//                getMenu = 0;
//            }
//
//        }
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
                    break;
                case 2:
                    break;
                case 3:
                    loopRouteWork();
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

    private static void loopRouteWork() {
        writeRouteWorkMenu();
        int k;
        try {
            k = new Scanner(System.in).nextInt();
            if (k == 0) {
                return;
            }
            switch (k) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer");
        }
        loopRouteWork();
    }
    
    private static void loopStation(){
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
}
