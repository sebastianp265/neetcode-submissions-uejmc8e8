class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        const numToCount = new Map();
        for (const n of nums) {
            const currentCount = numToCount.get(n);
            numToCount.set(n, currentCount === undefined ? 1 : currentCount + 1);
        }

        const buckets = new Array(nums.length + 1).fill(null);
        numToCount.forEach((count, n) => {
            if (buckets[count] === null) {
                buckets[count] = [n];
            } else {
                buckets[count] = [...buckets[count], n];
            }
        });

        const result = new Array(k);
        let resultInd = 0;
        for (let i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] !== null) {
                for (const n of buckets[i]) {
                    result[resultInd] = n;
                    resultInd++;
                    if (resultInd === k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}

