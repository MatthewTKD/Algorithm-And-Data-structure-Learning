// 实现Deque(Double ended que)双端队列
// front == tail -> deque is empty
// front == (tail + 1) % data.length -> deque is full
public class Deque<E> {

    E[] data;
    private int front;
    private int tail;
    private int size;

    public Deque(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public Deque() {
        this(10);
    }
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }

        return data[front];
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public void addFront(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        front = front - 1;
        if (front == -1) {
            front = front + 1 + getCapacity();
        }
        data[front] = e;
        size ++;
    }

    public void addLast(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public void removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if (getSize() / 4 == getCapacity() && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        tail = tail - 1;
        if (tail == -1) {
            tail = tail + 1 + getCapacity();
        }
        data[tail] = null;
        size --;
    }

    private void resize(int newCapacity) {
        int newFront = front;
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[newFront];
            newFront = (newFront + 1) % data.length;
        }
        front = 0;
        tail = size;
        data = newData;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: size = %d, capacity = %d \n", size,
                getCapacity()));
        res.append("front [");
        for (int i = front; i != tail;) {
            res.append(data[i]);
            i = (i + 1) % data.length;
            if (i != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<>();

        for (int i = 0; i < 10; i ++) {
            queue.addLast(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.removeLast();
                System.out.println(queue);
            }
        }
    }
}
