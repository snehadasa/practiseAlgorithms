package LeetCode.Easy.TreesSecondTime;


import LeetCode.Easy.MaxDepthOfBinaryTree;

public class MaxDepthOfBST {
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

    public  int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = Math.max(height(root.left), height(root.right));
        return h+1;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return height(root);
    }
}
