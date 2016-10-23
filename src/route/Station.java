package route;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Dmitry
 */
public class Station implements Serializable{
    
    private int id;
    private String name;
    private int typeRoad;
    
    public Station (){
        
    }
    
    public Station(int id, String name){
        this.id = id;
        this.name = name;
        this.typeRoad = new java.util.Random().nextInt(4);
    }
    
    public Station(int id, String name, int typeRoad){
        this.id = id;
        this.name = name;
        this.typeRoad = typeRoad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

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
        final Station other = (Station) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Station {\n  id: " + id + "\n  name: " + name + "\n  type road: " + typeRoad + "\n}\n";
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    
    
    
}
