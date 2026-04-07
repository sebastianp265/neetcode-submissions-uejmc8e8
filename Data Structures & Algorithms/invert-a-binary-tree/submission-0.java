class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        internalInvertTree(root);

        return root;
    }

    private static void internalInvertTree(TreeNode root) {
        if(root.left != null) {
            internalInvertTree(root.left);
        }
        if(root.right != null) {
            internalInvertTree(root.right);
        }
        var tmp = root.left;
        root.left = root.right;
        root.right = tmp;

    }
}

