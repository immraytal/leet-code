public class Task110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;

        int hl = dfs(root.left);
        int hr = dfs(root.right);

        return (Math.abs(hl - hr) < 2) && helper(root.left) && helper(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
