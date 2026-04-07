class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zerosCount = 0;
        for(int n : nums) {
            if (n != 0) {
                product *= n;
            } else {
                zerosCount++;
            }
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++) {
            if(nums[i] == 0) {
                if(zerosCount > 1) {
                    res[i] = 0;
                } else {
                    res[i] = product;
                }
            } else {
                if(zerosCount >= 1) {
                    res[i] = 0;
                } else {
                    res[i] = product / nums[i];
                }
            }
        }

        return res;
    }
}  
