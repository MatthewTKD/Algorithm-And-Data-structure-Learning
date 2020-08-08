// Deque更优雅的实现方式
// 使用size, 不浪费空间
// size = 0 -> Queue为空
// size = data.length -> Queue满了
public class Deque2<E> {

    E[] data;
    private int front;
    private int tail;
    private int size;

    public Deque2(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public Deque2() {
        this(10);
    }
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }

        return data[front];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size ++;
    }

    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if (getSize() / 4 == getCapacity() && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is empty");
        }
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail];
        data[tail] = null;
        size --;

        if (getSize() / 4 == getCapacity() && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
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
        for (int i = 0; i < size; i ++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        Deque2<Integer> queue2 = new Deque2<>();

        // 偶数从队尾加入，奇数从队首加入
        for (int i = 0; i < 16; i ++) {
            if (i % 2 == 0) {
                queue2.addLast(i);
            } else {
                queue2.addFront(i);
            }
            System.out.println(queue2);

        }

        System.out.println();
        // 从队首和队尾轮流删除元素
        for (int i = 0; !queue2.isEmpty(); i ++) {
            if (i % 2 == 0) {
                queue2.removeFront();
            } else {
                queue2.removeLast();
            }
            System.out.println(queue2);
        }
    }
}
