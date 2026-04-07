class MinStack {

    private int capacity = 2;
    private int[] stack = new int[capacity];
    private int[] minStack = new int[capacity];
    private int top = -1;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(top == stack.length - 1) {
            resizeStacks();
        }
        stack[++top] = val;
        if(top == 0 || val < minStack[top - 1]) {
            minStack[top] = val;
        } else {
            minStack[top] = minStack[top - 1];
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }

    private void resizeStacks() {
        capacity *= 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;

        int[] newMinStack = new int[capacity];
        System.arraycopy(minStack, 0, newMinStack, 0, minStack.length);
        minStack = newMinStack;
    }
}
