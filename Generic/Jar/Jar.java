package Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    public Deque<T> deque;

    public Jar(){
        this.deque = new ArrayDeque<>();
    }

    public void add(T element){
        this.deque.push(element);
    }

    public T remove(){
        return this.deque.pop();
    }
}
