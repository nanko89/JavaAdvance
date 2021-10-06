package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (capacity > this.data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : data) {
            if (pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner){
        Pet current = null;
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                current = pet;
            }
        }
        return current;
    }

    public Pet getOldestPet(){
        Pet oldest = null;
        for (Pet pet : this.data) {
            if (oldest == null ||pet.getAge() > oldest.getAge()){
                oldest = pet;
            }
        }
        return oldest;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The clinic has the following patients:"))
                .append(System.lineSeparator());
        for (Pet pet : this.data) {
            sb.append(pet.getName() + " ");
            sb.append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
