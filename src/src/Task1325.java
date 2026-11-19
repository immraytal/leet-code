public class Task1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        return dfs(root, target);
    }

    TreeNode dfs(TreeNode root, int target) {
        if (root == null) return null;
        TreeNode left = dfs(root.left, target);
        TreeNode right = dfs(root.right, target);
        root.left = left;
        root.right = right;
        if (isLeaf(root)) {
            if (root.val == target) return null;
        }
        return root;
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}
