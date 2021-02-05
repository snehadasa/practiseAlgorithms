package LeetCode.Easy.TreesSecondTime;


import LeetCode.Easy.DiameterOfBinaryTree;

public class DiameterOfBST {
    int result;

    public class TreeNode {
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

    public int depth(TreeNode root) {
     if (root == null) {
         return 0;
     }
     result = Math.max(result, Math.max(depth(root.left), depth(root.right)));
     return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    public int diameterOfBinaryTree1(TreeNode root) {

        result = 1;
        depth(root);
        return result - 1;
    }
}
