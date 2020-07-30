public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // add an element to the end of the array
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // Insert element e at index
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= " +
                    "size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;

        size++;
    }

    //Query the element at the index position
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Require index >=0 and index <= " +
                    "size");
        }

        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    //Change the element at the index position
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Require index >=0 and index <= " +
                    "size");
        }
        data[index] = e;
    }

    // Find weather there is element e in the array
    public boolean contains(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // Find the index of element e in the array, return -1 if not found
    public int find(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    // Remove the element at index position and return it
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= " +
                    "size");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i ++) {
            data[i - 1] = data[i];
        }

        size --;
        data[size] = null; // loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }
    public E removeFirst() {
        return remove(0);
    }
    public E removeLast() {
        return remove(size - 1);
    }

    // Remove the element e in the array, and return true if deleted successfully or return
    // false
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}
