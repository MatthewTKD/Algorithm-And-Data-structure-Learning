import java.util.Stack;
// 使用辅助栈来实现最小栈
// push()方法： 每当push()新值进来时，如果 小于等于 min_stack栈顶值，则一起push()到min_stack，即更新了栈顶最小值；
// pop()方法： 判断将pop()出去的元素值是否是min_stack栈顶元素值（即最小值），如果是则将min_stack栈顶元素一起pop()，这样可以保证min_stack栈顶元素始终是stack中的最小值
class MinStack {

    private Stack<Integer> s;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (s.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

