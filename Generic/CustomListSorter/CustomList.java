package CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList <T extends Comparable <T>> implements Iterable<T>{
    private List<T> elements;


    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements(){
        return this.elements;
    }

    public void add(T element){
        this.elements.add(element);
    }

    public T remove(int index){
        return this.elements.remove(index);
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public void swap(int first, int second){
        T firstElement = elements.get(first);
        T secondElement = elements.get(second);
        elements.set(first,secondElement);
        elements.set(second,firstElement);
    }

    public int countGreaterThan(T element){
        return (int)this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax(){
        return elements.stream().max(Comparable::compareTo).get();
    }

    public T getMin(){
        return elements.stream().min((a,b) -> a.compareTo(b)).get();
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}
