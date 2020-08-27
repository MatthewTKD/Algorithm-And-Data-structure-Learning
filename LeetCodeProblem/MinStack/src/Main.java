public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.top();
        minStack.top();
        System.out.println(minStack.getMin());
    }
}
