package ExerciseGenericBoxSwapMethod;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
        private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            sb.append(String.format("%s: %s", element.getClass().getName(),element));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public void swap(int firstIndex, int secondIndex){
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);
        this.elements.set(firstIndex,secondElement);
        this.elements.set(secondIndex,firstElement);
    }
}
