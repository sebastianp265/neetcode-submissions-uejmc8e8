class Solution {
    /**
     * @param {number[]} temperatures
     * @return {number[]}
     */
    dailyTemperatures(temperatures) {
        const n = temperatures.length;
        if (n < 1) return [];

        const result = new Array(n).fill(0);
        const stack = new Array(n);
        stack[0] = 0;
        let stackTop = 0;

        for (let i = 1; i < n; i++) {
            //     i i+1
            // 0 1 2 3
            // 3 2 1 2
            while (stackTop >= 0 && temperatures[stack[stackTop]] < temperatures[i]) {
                result[stack[stackTop]] = i - stack[stackTop];
                stackTop--;
            }
            stack[++stackTop] = i;
        }

        return result;
    }
}
