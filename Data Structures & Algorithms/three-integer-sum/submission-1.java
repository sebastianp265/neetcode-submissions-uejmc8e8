class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> results = new HashSet<>();

        for(int k = 0; k < nums.length; k++) {
            // nums[i] + nums[j] == -nums[k] 
            int l = 0;
            int r = nums.length - 1;
            while(l < r) {
                if(l == k) {
                    l++;
                    continue;
                }
                if(r == k) {
                    r--;
                    continue;
                }

                int sum = nums[l] + nums[r];
                if(sum == -nums[k]) {
                    results.add(sortTriplet(nums[l], nums[r], nums[k]));
                    l++;
                } else if(sum > -nums[k]) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new ArrayList<>(results);
    }

    private List<Integer> sortTriplet(int a, int b, int c) {
        int temp;
        if(a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if(b > c) {
            temp = b;
            b = c;
            c = temp;
        }
        if(a > b) {
            temp = a;
            a = b;
            b = temp;
        }

        return List.of(a, b, c);
    }



}
