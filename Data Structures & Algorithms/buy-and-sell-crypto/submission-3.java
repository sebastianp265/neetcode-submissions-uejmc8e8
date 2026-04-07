

class Solution {
    public int maxProfit(int[] prices) {
        var lowestPrice = prices[0];
        var maxProfit = 0;

        for(var p : prices) {
            lowestPrice = Math.min(lowestPrice, p);
            maxProfit = Math.max(maxProfit, p - lowestPrice);
        }

        return maxProfit;
    }
}
