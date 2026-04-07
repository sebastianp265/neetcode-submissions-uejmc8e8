class Solution {

    String counterToString(Map<Character, Integer> counter) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> e : counter.entrySet()) {
            sb.append(e.getKey().toString()).append(e.getValue());
        }

        return sb.toString();
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> counterToGroup = new HashMap<>();
        for(String s: strs) {
            Map<Character, Integer> counter = new TreeMap<>();
            for(int i = 0; i < s.length(); i++) {
                counter.compute(s.charAt(i), (k, v) -> v == null ? 0 : v + 1);
            }
            counterToGroup.compute(counterToString(counter), (k, v) -> {
                if(v == null) {
                    return new ArrayList<>(List.of(s));
                } else {
                    v.add(s);
                    return v;
                }
            });
        }

        return new ArrayList<>(counterToGroup.values());
    }
}

