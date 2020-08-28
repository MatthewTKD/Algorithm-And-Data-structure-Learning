// 使用虚拟头节点dummyHead作为队首
// tail作为队尾
public class LinkedListQueue2<E> implements Queue<E> {
    class Node {
        private E e;
        private Node next;

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
    private Node tail;
    private int size;

    public LinkedListQueue2() {
        dummyHead = new Node(null, null);
        tail = null;
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            dummyHead.next = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue failed. Queue is empty");
        }

        Node delNode = dummyHead.next;
        dummyHead.next = delNode.next;
        delNode.next = null;

        size --;

        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return dummyHead.next.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue front ");
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("Null tail");

        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue2<Integer> queue = new LinkedListQueue2<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
