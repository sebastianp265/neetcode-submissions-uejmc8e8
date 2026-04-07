
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int n : nums) {
            counter.merge(n, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> counts = new ArrayList<>(counter.entrySet());
        counts.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        return counts.subList(0, k)
                .stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
