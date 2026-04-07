class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        var stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var popped = stack.pop();
            var tmp = popped.left;
            popped.left = popped.right;
            popped.right = tmp;
            
            if (popped.left != null) {
                stack.push(popped.left);
            }
            if (popped.right != null) {
                stack.push(popped.right);
            }
        }

        return root;
    }

}
