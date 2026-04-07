class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> counterToGroup = new HashMap<>();
        for(String s : strs) {
            Map<Character, Integer> counter = new TreeMap<>();
            for(int i = 0; i < s.length(); i++) {
                counter.merge(s.charAt(i), 1, Integer::sum);
            }
            counterToGroup
                .computeIfAbsent(counter.toString(), (k) -> new ArrayList<>())
                .add(s);
        }

        return new ArrayList<>(counterToGroup.values());
    }
}

