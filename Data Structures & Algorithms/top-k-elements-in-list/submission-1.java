
class Solution {
     public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.merge(n, 1, Integer::sum);
        }

        TreeMap<Integer, List<Integer>> buckets = new TreeMap<>();
        for(Map.Entry<Integer, Integer> e : counter.entrySet()) {
            buckets.computeIfAbsent(e.getValue(), n -> new ArrayList<>()).add(e.getKey());
        }

        int[] result = new int[k];
        int j = 0;
        for (Map.Entry<Integer, List<Integer>> e : buckets.descendingMap().entrySet()) {
            for(Integer i : e.getValue()) {
                result[j++] = i;
            }
            if(j == k) {
                break;
            }
        }
        
        return result;
    }
}
