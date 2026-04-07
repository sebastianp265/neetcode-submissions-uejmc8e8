class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> diffToIndex = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            Integer matchedIndex = diffToIndex.get(numbers[i]);
            if(matchedIndex != null) {
                return new int[]{matchedIndex + 1, i + 1};
            }

            diffToIndex.put(target - numbers[i], i);
        }

        return null;
    }
}
