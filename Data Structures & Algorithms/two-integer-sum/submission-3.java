class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffs = new HashMap<>();

        for(int j = 0; j < nums.length; j++) {
            Integer i = diffs.get(nums[j]);
            if(i != null && i != j) {
                return new int[]{i, j};
            }
            diffs.put(target - nums[j], j);
        }

        return null;
    }
}
