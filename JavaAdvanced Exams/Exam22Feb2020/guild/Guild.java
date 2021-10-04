package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Guild {
    public String name;
    public int capacity;
    public List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            roster.remove(index);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        int indexPlayer = findPlayerIndex(name);
        if (indexPlayer != - 1) {
            roster.get(indexPlayer).setRank("Member");
        }
    }

    private int findPlayerIndex(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void demotePlayer(String name) {
        int indexPlayer = findPlayerIndex(name);
        if (indexPlayer != - 1) {
            roster.get(indexPlayer).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] player = this.roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);
        this.roster = this.roster.stream()
                .filter(p -> !p.getClazz().equals(clazz))
                .collect(Collectors.toList());
        return player;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Players in the guild: %s:%n", this.name));
        for (Player player : this.roster) {
            sb.append(player).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}
