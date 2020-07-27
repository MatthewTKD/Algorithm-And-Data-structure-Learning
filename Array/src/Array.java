public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        this.data = new int[capacity];
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
    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    // Insert element e at index
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild. Require index >=0 and index <= " +
                    "size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;

        size++;
    }

    //Query the element at the index position
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild. Require index >=0 and index <= " +
                    "size");
        }

        return data[index];
    }

    //Change the element at the index position
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add faild. Require index >=0 and index <= " +
                    "size");
        }
        data[index] = e;
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

