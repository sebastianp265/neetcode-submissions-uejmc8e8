class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while(l < r) {
            maxArea = Math.max(maxArea, area(heights, l, r));
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    private int area(int[] heights, int l, int r) {
       return (r - l) * Math.min(heights[l], heights[r]);
    }
}
