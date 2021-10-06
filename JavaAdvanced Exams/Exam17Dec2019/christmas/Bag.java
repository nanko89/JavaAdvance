package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color.substring(0,1).toUpperCase() + color.substring(1).toLowerCase();;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count(){
        return this.data.size();
    }

    public void add(Present present){
        if (this.capacity > this.data.size()){
            this.data.add(present);
        }
    }

    public boolean remove(String name){
        for (Present present : this.data) {
            if (present.getName().equals(name)){
                this.data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent(){
        Present heaviestPresent = null;
        for (Present present : this.data) {
            heaviestPresent = present;
            if (present.getWeight() > heaviestPresent.getWeight()){
                heaviestPresent = present;
            }
        }
        return  heaviestPresent;
    }

    public Present getPresent(String name){
        Present currentPresent = null;
        for (Present present : this.data) {
            if (present.getName().equals(name)){
                currentPresent = present;
            }
        }
        return currentPresent;
    }

    public String report(){
        StringBuilder sb = new StringBuilder(String.format("%s bag contains:%n", this.color));
        for (Present present : this.data) {
            sb.append(present.toString())
            .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
