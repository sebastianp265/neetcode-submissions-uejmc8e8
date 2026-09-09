

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(
            results,
            new ArrayList<>(),
            nums,
            0,
            target
        );
        return results;
    }

    private void dfs(
        List<List<Integer>> result,
        List<Integer> subset,
        int[] nums,
        int start,
        int target
    ) {
        var sum = subset.stream()
            .mapToInt(Integer::intValue)
            .sum();
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(result, subset, nums, i, target);
            subset.removeLast();
        }
    }

}




void main() {
    var sol = new Solution();

    System.out.println(sol.combinationSum(new int[]{2, 3, 5, 4}, 7));


}
