class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterToPosition = new HashMap<>();
        var l = 0;
        var r = 0;
        var result = 0;
        while (r < s.length()) {
            if (characterToPosition.containsKey(s.charAt(r))) {
                var newL = characterToPosition.get(s.charAt(r)) + 1;
                IntStream.range(l, newL)
                    .forEach(i -> characterToPosition.remove(s.charAt(i)));
                l = newL;
            }
            result = Math.max(result, r - l + 1);
            characterToPosition.put(s.charAt(r), r);
            r++;
        }

        return result;
    }
}
