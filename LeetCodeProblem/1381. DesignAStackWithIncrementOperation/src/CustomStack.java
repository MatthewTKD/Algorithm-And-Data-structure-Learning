class CustomStack {
    private int[] array;
    private int size;

    public CustomStack(int maxSize) {
        array = new int[maxSize];
        size = 0;
    }

    public void push(int x) {
        if (size == array.length) {
            return;
        }
        array[size] = x;
        size ++;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        size --;
        return array[size];
    }

    public void increment(int k, int val) {
        if (size < k) {
            for (int i = 0; i < size; i ++ ) {
                array[i] += val;
            }
        } else {
            for (int i = 0 ; i < k; i ++ ) {
                array[i] += val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */