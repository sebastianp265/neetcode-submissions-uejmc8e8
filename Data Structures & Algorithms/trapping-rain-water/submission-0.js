class Solution {
    /**
     * @param {number[]} height
     * @return {number}
     */
    trap(height) {
        let result = 0;

        const n = height.length;

        let maxHeight = 0;
        for (const h of height) {
            maxHeight = Math.max(h, maxHeight);
        }

        for (let i = 0; i < maxHeight; i++) {
            let leftBarIndex = 0;
            while (leftBarIndex !== n) {
                while (leftBarIndex < n) {
                    if (height[leftBarIndex] > 0) {
                        break;
                    }
                    leftBarIndex++;
                }
                if (leftBarIndex === n) {
                    break;
                }
                let rightBarIndex = leftBarIndex + 1;
                while (rightBarIndex < n) {
                    if (height[rightBarIndex] > 0) {
                        break;
                    }
                    rightBarIndex++;
                }
                if (rightBarIndex === n) {
                    break;
                }

                result += rightBarIndex - leftBarIndex - 1;
                leftBarIndex = rightBarIndex;
            }
            for (let j = 0; j < height.length; j++) {
                height[j]--;
            }
        }

        return result;
    }
}
