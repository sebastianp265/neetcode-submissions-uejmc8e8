
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(
            res,
            Arrays.stream(nums).boxed().toList(),
            new ArrayList<>()
        );

        return res;
    }

    private void permute(
        List<List<Integer>> res,
        List<Integer> options,
        List<Integer> permutation
    ) {
        if(options.isEmpty()) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for(var chosenOption : options) {
            permutation.addLast(chosenOption);

            permute(
                res,
                options.stream().filter(option -> !option.equals(chosenOption)).toList(),
                permutation
            );

            permutation.removeLast();
        }
    }
}
