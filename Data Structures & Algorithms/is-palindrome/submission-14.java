class Solution {    

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        
        while(left < right) {
            while(left < n  && !isAlphaNumeric(s.charAt(left))  ) {
                left++;
            }
            while(right >= 0 && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }
            if(left >= right || left >= n || right < 0) {
                return true;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return c >= 'A' && c <= 'Z' || 
            c >= 'a' && c <= 'z' || 
            c >= '0' && c <= '9';
    }
}
