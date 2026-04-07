class MinStack {

    private int capacity = 2;
    private int[] stack = new int[capacity];
    private int top = -1;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(top == stack.length - 1) {
            resizeStack();
        }
        stack[++top] = val;
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        int min = stack[top];
        for(int i = top - 1 ; i >= 0; i--) {
            if(stack[i] < min) {
                min = stack[i];
            }
        }

        return min;
    }

    private void resizeStack() {
        capacity *= 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
