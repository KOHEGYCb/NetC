package route;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dmitry
 */
public class ArrStations implements Serializable {

    private List<Station> stations = new ArrayList<Station>();

    public ArrStations() {
//        this.stations = new ArrayList<Station>();
        this.stations = (List<Station>) deser();
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

    private Object deser() {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream("stations.t");
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Error read/write");
            System.exit(1);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
            System.exit(2);
        }
        return obj;
    }

    public void ser() {
        try {
            FileOutputStream fos = new FileOutputStream("stations.t");
            ObjectOutputStream ofs = new ObjectOutputStream(fos);
            ofs.writeObject(this.stations);
            fos.close();
            ofs.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error read/write");
        }
    }

    public void addStation() {
        System.out.print("*****\n"
                + "Write name: ");
        String str = new Scanner(System.in).next();
        stations.add(new Station(stations.size() + 1, str));
        System.out.println("Station created\n*****");
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < stations.size(); i++) {
            str = str + stations.get(i);
        }
        return str;
    }

    public void remuveStation() {
        System.out.print("*****\n"
                + "Write id: ");
        try {
            int id = new Scanner(System.in).nextInt();
            boolean find = false;
            for (int i = 0; i < stations.size(); i++) {
                if (stations.get(i).getId() == id) {
                    find = true;
                    stations.remove(i);
                    for (int j = i; j < stations.size(); j++) {
                        stations.get(j).setId(j + 1);
                    }
                }
            }
            if (!find) {
                System.out.println("Id not found\nStation not remuved\n*****");
                return;
            }
        } catch (InputMismatchException ime) {
            System.out.println("Not integer\nStation not remuved\n*****");
            return;
        }
        System.out.println("Station remuved\n*****");
    }

    public void renameStation() {
        System.out.print("*****\n"
                + "Write id: ");
        try {
            int id = new Scanner(System.in).nextInt();
            boolean find = false;
            int i;
            for (i = 0; i < stations.size(); i++) 
                if (stations.get(i).getId() == id){ 
                    find = true;
                    break;
                }
            if (!find) {
                System.out.println("Id not found\nStation not remuved\n*****");
                return;
            }
            System.out.print("Station found\nWrite new name: ");
            String name = new Scanner(System.in).next();
            stations.get(i).setName(name);
        } catch (InputMismatchException ime) {
            System.out.println("Not integer\nStation not remuved\n*****");
            return;
        }
        System.out.println("Station remuved\n*****");
    }

}
