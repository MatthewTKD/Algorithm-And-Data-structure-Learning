import java.util.Queue;
import java.util.LinkedList;
// push复杂度为O(1)
// pop复杂度为O(n)
public class MyStack2 {

    private Queue<Integer> queue1;
    private int top; // 维护一个变量来监视栈顶的元素，使top()的复杂度变为O(1)
    /** Initialize your data structure here. */
    public MyStack2() {
        queue1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> queue2 = new LinkedList<>();
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        int ret = queue1.remove();
        queue1 = queue2;
        return ret;
    }

    /** Get the top element. */
    public int top() {
        return top;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
