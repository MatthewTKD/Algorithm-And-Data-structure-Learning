public class Main {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);

        for(int i = 1; i < 5; i ++) {
            queue.enQueue(i);
            System.out.println(queue);
        }

        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        queue.deQueue();
        System.out.println(queue);
        queue.enQueue(4);
        System.out.println(queue);
        System.out.println(queue.Rear());
    }
}
