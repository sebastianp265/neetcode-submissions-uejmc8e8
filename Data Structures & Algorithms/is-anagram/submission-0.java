class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> counter = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            counter.merge(s.charAt(i), -1, Integer::sum);
            counter.merge(t.charAt(i), 1, Integer::sum);            
        }

        for(Integer v : counter.values()) {
            if(v != 0) {
                return false;
            }
        }

        return true;
    }
}
