class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(
        List<List<Integer>> results,
        List<Integer> subset,
        int[] nums,
        int i
    ) {
        if(i >= nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(results, subset, nums, i + 1);
        subset.removeLast();
        dfs(results, subset, nums, i + 1);
    }
}