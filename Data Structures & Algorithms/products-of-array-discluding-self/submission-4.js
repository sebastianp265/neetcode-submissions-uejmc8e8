class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums) {
        let zeroCount = 0;

        const productNotCountingZeros = nums.reduce((acc, cur) => {
            zeroCount += cur === 0;
            return cur === 0 ? acc : acc * cur;
        }, 1);

        if (zeroCount === 0) {
            return nums.map((v) => productNotCountingZeros / v);
        }
        if (zeroCount === 1) {
            return nums.map((v) => (v === 0 ? productNotCountingZeros : 0));
        }

        return new Array(nums.length).fill(0);
    }
}
