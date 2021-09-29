import java.util.Iterator;
import java.util.function.Consumer;

public class Stack implements Iterable<Integer>{
    private static class Node {
        private int element;
        private Node prev;

        public Node (int element){
            this.element = element;
        }
    }
    @Override
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private Node current = top;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int value = current.element;
                current = current.prev;
                return value;
            }
        };
    }


    private Node top;
    private int size;

    public Stack (){

    }

    public void push(int element){
        Node newNode = new Node(element);
        if (top != null){
            newNode.prev = top;
        }
        top = newNode;
        this.size++;
    }

    public int pop(){
        ensureNonEmpty();
        int element = top.element;
        Node oldTop = top;
        top = top.prev;
        oldTop.prev = null;

        this.size--;
        return element;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

//    public void forEach(Consumer<Integer> consumer){
//        Node current = top;
//        while (current != null){
//            consumer.accept(current.element);
//            current = current.prev;
//        }
//    }
    public void ensureNonEmpty(){
        if (isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
    }
    public int peek(){
        ensureNonEmpty();
        return top.element;
    }
}
