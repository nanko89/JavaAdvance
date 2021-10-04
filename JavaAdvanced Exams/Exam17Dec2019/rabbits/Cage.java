package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private int capacity;
    private String name;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }


    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()){
            this.data.add(rabbit);
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (data.get(i).getName().equals(name)){
                this.data.get(i).setAvailable(false);
                rabbit = this.data.get(i);
                break;
            }

        }
        return rabbit;

    }

    public boolean removeRabbit(String rabbitName) {
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)){
                index = i;
            }
        }
        if (index != -1){
            this.data.remove(index);
            return true;
        }
        return false;
    }

    public void removeSpecies(String species) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)){
                indexes.add(i);
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            this.data.remove(indexes.get(i) - i);
        }
    }

    public List<Rabbit> sellRabbitBySpecies(String s) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getSpecies().equals(s)){
                rabbit.setAvailable(false);
                rabbits.add(rabbit);
            }
        }
        return rabbits;
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format
                ("Rabbits available at %s:%n", this.name));
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()){
                sb.append(rabbit.toString())
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    public int count() {
        return this.data.size();
    }
}
