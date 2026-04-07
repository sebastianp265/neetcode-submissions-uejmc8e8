class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        int[] postfixes = new int[nums.length];

        prefixes[0] = nums[0];
        postfixes[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++) {
            prefixes[i] = prefixes[i - 1] * nums[i];
            postfixes[nums.length - 1 - i] = postfixes[nums.length - i] * nums[nums.length - 1 - i];
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = (i - 1 >= 0 ? prefixes[i - 1] : 1) * (i + 1 < nums.length ? postfixes[i + 1] : 1);  
        }

        return res;
    }
}  
