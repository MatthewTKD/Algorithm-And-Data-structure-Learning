import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            for (int i = 0; i < queue2.size(); i ++) {
                int ret = queue2.remove();
                queue1.add(ret);
            }
        } else {
            queue2.add(x);
            for (int i = 0; i < queue1.size(); i ++) {
                int ret = queue1.remove();
                queue2.add(ret);
            }
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ret;
        if (queue1.isEmpty()) {
            ret = queue2.remove();
        } else {
            ret = queue1.remove();
        }
        return ret;
    }

    /** Get the top element. */
    public int top() {
        int ret;
        if (queue1.isEmpty()) {
            ret = queue2.peek();
        } else {
            ret = queue1.peek();
        }
        return ret;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */