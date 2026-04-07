
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterToPosition = new HashMap<>();
        var l = 0;
        var r = 0;
        var result = 0;
        while (r < s.length()) {
            if (characterToPosition.containsKey(s.charAt(r))) {
                l = Math.max(l, characterToPosition.get(s.charAt(r)) + 1);
            }
            result = Math.max(result, r - l + 1);
            characterToPosition.put(s.charAt(r), r);
            r++;
        }

        return result;
    }
}
