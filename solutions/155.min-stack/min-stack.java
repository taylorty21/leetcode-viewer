public class MinStack {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList<>();
	    stack2 = new LinkedList<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty() && stack2.peek() < x) {
          stack2.push(stack2.peek());
        } else {
          stack2.push(x);
        }
    }
    
    public void pop() {
        if (!stack1.isEmpty() && !stack2.isEmpty()) {
            stack2.pop();
            stack1.pop();
        }
    }
    
    public int top() {
        if (!stack1.isEmpty()) {
          return stack1.peek();
        } else {
          return -1;
        }  
    }
    
    public int getMin() {
        if (!stack2.isEmpty()) {
          return stack2.peek();
        } else {
          return -1;
        }
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