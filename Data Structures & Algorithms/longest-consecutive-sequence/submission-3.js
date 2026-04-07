class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    longestConsecutive(nums) {
        let maxSequenceLength = 0;
        const numsSet = new Set(nums);

        for (const n of nums) {
            const isNStartOfASequence = !numsSet.has(n - 1);
            if (isNStartOfASequence) {
                let currentElement = n;
                let sequenceLength = 1;

                while (numsSet.has(currentElement + 1)) {
                    currentElement++;
                    sequenceLength++;
                }

                maxSequenceLength = Math.max(maxSequenceLength, sequenceLength);
            }
        }

        return maxSequenceLength;
    }
}
