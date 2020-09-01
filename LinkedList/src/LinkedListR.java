import javax.print.attribute.standard.SheetCollate;

// LinkedList递归实现
public class LinkedListR<E> {
    class Node {
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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal");
        }

        head = add(head, index, e);

        size++;
    }

    // 以node为头节点在index位置插入元素e, 递归算法
    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);

        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }

        head = remove(head, index);
        size--;
    }

    // 删除以node为头节点的index位置出的元素
    private Node remove(Node node, int index) {
        if (index == 0) {
            return node.next;
        }

        node.next = remove(node.next, index - 1);

        return node;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }

        return get(head, index);

    }

    // 找到以node为头节点的第index位置处的元素
    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }

        set(head, index, e);

    }

    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
        }

        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }

        return contains(node.next, e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }

        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListR<Integer> list = new LinkedListR<>();
        for (int i = 0; i < 10; i++) {

            list.addFirst(i);
            System.out.println(list);

        }
        while (!list.isEmpty()) {
            list.removeLast();
            System.out.println(list);

        }
    }
}
