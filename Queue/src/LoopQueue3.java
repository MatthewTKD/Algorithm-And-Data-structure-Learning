// 不维护size, 只是使用front和tail，浪费一个空间
// tail = front -> Queue is empty
// (tail + 1) % data.length = front -> Queue is full
public class LoopQueue3<E> implements Queue<E> {

    E[] data;
    private int front;
    private int tail;

    public LoopQueue3(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue3() {
        this(10);
    }

    @Override
    public int getSize() {
        if (tail > front) {
            return tail - front;
        } else {
            return data.length - front + tail;
        }
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        return data[front];
    }

    public void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        int size = getSize();
        for (int i = 0; i < size; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue3: size = %d, capacity = %d \n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(i);
            if (i != tail - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LoopQueue3<Integer> queue = new LoopQueue3<>();

        for (int i = 0; i < 10; i ++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
