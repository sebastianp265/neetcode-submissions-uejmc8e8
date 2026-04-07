 class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums, target) {
        const sortBreak = this._searchForSortBreak(nums);
        const firstPart = this._binarySearch(nums, target, 0, sortBreak - 1);
        const secondPart = this._binarySearch(nums, target, sortBreak, nums.length - 1);

        if (firstPart !== -1) {
            return firstPart;
        }
        if (secondPart !== -1) {
            return secondPart;
        }

        return -1;
    }

    _binarySearch(nums, target, l, r) {
        while (l <= r) {
            const m = l + Math.floor((r - l) / 2);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    _searchForSortBreak(nums) {
        let l = 0;
        let r = nums.length - 1;
        if (nums[l] < nums[r]) return 0;

        while (l < r) {
            const m = l + Math.floor((r - l) / 2);
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
