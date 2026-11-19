public class Task979 {
    int result;
    public int distributeCoins(TreeNode root) {
        result = 0;
        postOrder(root);
        return result;
    }

    int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result += Math.abs(left) + Math.abs(right);
        return (root.val - 1) + left+ right;
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
