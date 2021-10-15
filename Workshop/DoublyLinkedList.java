public class DoublyLinkedList {
    private class Node {
       private int element;
        private Node next;
        private Node prev;

        private Node(int element){
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element){
        Node newNode = new Node(element);
        if (this.size == 0){
            this.head = this.tail = newNode;
        }else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element){
        Node newNode = new Node((element));
        if (this.size == 0){
            this.head = this.tail = newNode;
        }else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }


}
