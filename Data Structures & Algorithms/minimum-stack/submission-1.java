class MinStack {
        int min = Integer.MAX_VALUE;
        ArrayDeque<Integer> stack;
        ArrayDeque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (val <= min) {
            min = val;
            minStack.addLast(val);
        }
    }
    
    public void pop() {
        int popped = stack.removeLast();
        if (minStack.getLast() == popped) {
            minStack.removeLast();
            if (minStack.size() > 0) min = minStack.getLast();
            else min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min;
    }
}
