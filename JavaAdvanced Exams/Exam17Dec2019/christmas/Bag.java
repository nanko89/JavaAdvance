package Exam17Dec2019.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getColor() {
        return this.color;
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
        Present newPresent = null;
        for (Present present : this.data) {
            if (newPresent == null || present.getWeight() > newPresent.getWeight()){
                newPresent = present;
            }
        }
        return newPresent;
    }

    public Present getPresent(String name){
        Present newPresent = null;
        for (Present present : this.data) {
            if (present.getName().equals(name)){
                newPresent = present;
            }
        }
        return newPresent;
    }

    public String report() {
        StringBuilder str = new StringBuilder(String.format("%s bag contains:%n", this.getColor()));
        for (Present present : this.data) {
            str.append(present.toString()).append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
