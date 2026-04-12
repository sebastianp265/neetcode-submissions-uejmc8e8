class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        dfs(root, result, 0);

        return result;
    }

    private void dfs(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        if (result.size() <= depth) {
            result.add(node.val);
        } else {
            result.set(depth, node.val);
        }

        dfs(node.left, result, depth + 1);
        dfs(node.right, result, depth + 1);
    }

}
