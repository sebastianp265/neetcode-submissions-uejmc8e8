class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case ')':
                    if(stack[top] == '(') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if(stack[top] == '[') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if(stack[top] == '{') {
                        top--;
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack[++top] = c;
            }
        }
        if(top == 0) { 
            return true;
        } else {
            return false;
        }
    }
}
