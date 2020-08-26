import java.util.Stack;
// 使用两个栈
// 小改进，如果Stack2不为空，pop时直接popStack2栈顶元素即可，避免重复操作
// push复杂度O(1)
// pop均摊复杂度O(1)
class MyQueue3 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front; //监视队首元素，使peek复杂度为O(1)
    /** Initialize your data structure here. */
    public MyQueue3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 如果Stack2不为空，直接放回Stack2栈顶元素
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */