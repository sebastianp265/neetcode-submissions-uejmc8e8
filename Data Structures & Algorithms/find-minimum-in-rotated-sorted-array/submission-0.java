class Solution {
    public int findMin(int[] nums) {
        var l = 0;
        var r = nums.length - 1;
        while(l < r) {
            int p = (r - l) / 2 + l;
            if(nums[p] > nums[r]) {
                l = p + 1;
            } else if(nums[p] > nums[l]) {
                r = p - 1;
            } else {
                r = p;
            }
        }

        return nums[l];
    }
}
