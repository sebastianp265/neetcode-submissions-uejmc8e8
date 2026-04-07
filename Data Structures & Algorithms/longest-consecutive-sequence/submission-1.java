class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> choices = new TreeSet<>();
        
        for(int n : nums) {
            choices.add(n);
        }

        int prev = choices.first();
        int length = 1;
        int maxLength = 1; 
        for(int n : choices) {
            System.out.println(n - prev);
            if(n - prev == 1) {
                length++;
            } else {
                if(length > maxLength) {
                    maxLength = length;
                }
                length = 1;
            }
            prev = n;
        }
        if(length > maxLength) {
            maxLength = length;
        }

        return maxLength;
    }
}
