public class LinkedList<E> {

    class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is illegal");
        }

        Node prev = dummyHead;
        for (int i = 0; i < size; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);

        size++;
    }

    public void addFirst(E e) {
        add(0,e);
    }



    public void addLast(E e) {
        add(size, e);
    }

}
