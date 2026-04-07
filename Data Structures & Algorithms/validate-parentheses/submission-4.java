class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );
        char[] stack = new char[s.length()];
        int top = -1;

        for(char c : s.toCharArray()) {
            if(closeToOpen.containsKey(c)) {
                if(top != -1 && stack[top] == closeToOpen.get(c)) {
                    top--;
                } else {
                    return false;
                }
            } else {
                stack[++top] = c;
            }
        }
        return top == -1;
    }
}
