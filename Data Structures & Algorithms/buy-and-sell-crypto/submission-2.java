

class Solution {
    public int maxProfit(int[] prices) {
        var lowestPrice = prices[0];
        var largestPrice = prices[0];
        var maxProfit = 0;

        for(var p : prices) {
            if(p < lowestPrice) {
                lowestPrice = p;
                largestPrice = p;
            } else if (p > largestPrice) {
                largestPrice = p;
            }
            maxProfit = Math.max(maxProfit, largestPrice - lowestPrice);
        }

        return maxProfit;
    }
}
