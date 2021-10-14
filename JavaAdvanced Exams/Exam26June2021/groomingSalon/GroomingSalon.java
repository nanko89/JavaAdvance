package Exam26June2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                pet = p;
            }
        }
        return pet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:")
                .append(System.lineSeparator());
        for (Pet pet : this.data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
