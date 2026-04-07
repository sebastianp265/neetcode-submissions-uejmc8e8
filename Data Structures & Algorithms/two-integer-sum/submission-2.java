class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffs = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            diffs.put(target - nums[i], i);
        }
        for(int j = 0; j < nums.length; j++) {
            Integer i = diffs.get(nums[j]);
            if(i != null && i != j) {
                return new int[]{j, i};
            }
        }

        return null;
    }
}
