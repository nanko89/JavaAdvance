package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if (capacity > this.roster.size()){
            this.roster.add(person);
        }
    }

    public boolean remove(String name){
        return roster.removeIf(p-> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown){
        return roster.stream()
                .filter(p->p.getName().equals(name) && p.getHometown().equals(hometown))
                .findFirst().orElse(null);
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", name));
        for (Person person : this.roster) {
            sb.append(person.toString())
                    .append(System.lineSeparator()) ;
        }
        return sb.toString().trim();
    }


}
