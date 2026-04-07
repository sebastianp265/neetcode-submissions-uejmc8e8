class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            try {
                Integer value = Integer.parseInt(token);
                stack.push(value);
            } catch(NumberFormatException e) {
                char operator = token.charAt(0);
                Integer second = stack.pop();
                Integer first = stack.pop();
                
                Integer result;
                switch(operator) {
                    case '+':
                        result = first + second;
                        break;
                    case '-':
                        result = first - second;
                        break;
                    case '*':
                        result = first * second;
                        break;
                    case '/':
                        result = first / second;
                        break;
                    default:
                        throw new IllegalArgumentException("Got unexpected token: " + operator);
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
