class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        const n = height.length;
        if (n > 1000 || n < 1) {
            return 0;
        }
        const prefix = new Array(height.length).fill(0);
        prefix[0] = height[0];
        const suffix = new Array(height.length).fill(0);
        suffix[n - 1] = height[n - 1];

        for (let i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        for (let i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        let result = 0;

        for (let i = 1; i < n - 1; i++) {
            result += Math.max(0, Math.min(prefix[i - 1], suffix[i + 1]) - height[i]);
        }

        return result;
    }
}