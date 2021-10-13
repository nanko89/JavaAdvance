package DoubleLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (!isEmpty()) {
            newNode.next = head;
            this.head.prev = newNode;
        } else {
            this.tail = newNode;
        }
        this.head = newNode;
        this.size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        tail = newNode;
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);
        int result = 0;
        if (index <= this.size / 2) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.value;
        } else {
            Node currentNode = this.tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            result = currentNode.value;
        }
        return result;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("The index " + index + "is out of bounds");
        }
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list");
        } else {
            int result = this.head.value;
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            if (isEmpty()) {
                this.head = this.tail = null;
            }
            return result;
        }
    }

    public int removeLast() {
        if (this.size < 2) {
            return removeFirst();
        }
        int result = this.tail.value;
        this.tail = this.tail.prev;
        if (this.size > 1) {
            this.tail.next = null;
        }
        return result;
    }

    public int[] toArray() {
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    private int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
