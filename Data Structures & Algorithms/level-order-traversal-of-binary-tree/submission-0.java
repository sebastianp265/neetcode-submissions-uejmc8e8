class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode node, int depth) {
        if(node == null) return;

        if(result.size() <= depth) {
            var newList = new ArrayList<Integer>();
            newList.add(node.val);
            result.add(newList);
        } else {
            result.get(depth).add(node.val);
        }
        levelOrder(result, node.left, depth + 1);
        levelOrder(result, node.right, depth + 1);
    }
}
