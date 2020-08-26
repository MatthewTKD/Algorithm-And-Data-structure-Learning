import java.util.LinkedList;
import java.util.Queue;
// 只用一个队列
class MyStack3 {
    private Queue<Integer> queue1;

    /** Initialize your data structure here. */
    public MyStack3() {
        queue1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 首先将x入队
        queue1.add(x);
        // 执行n-1次入队再出队的操作
        for (int i = 1; i < queue1.size(); i ++) {
            queue1.add(queue1.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
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