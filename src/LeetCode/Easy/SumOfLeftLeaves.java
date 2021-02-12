package LeetCode.Easy;

import com.sun.source.tree.Tree;

public class SumOfLeftLeaves {
//    Find the sum of all left leaves in a given binary tree.
//
//    Example:
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//
//    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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

        boolean isLeaf() {
            return left == null ? right == null : false;
        }
    }

    private int totalSum = 0;

    public void calculateSum(TreeNode root) {
        if (root.left != null && root.left.left == null && root.left.right == null) {
            totalSum += root.left.val;
        }
        if (root.left != null) {
            calculateSum(root.left);
        }
        if (root.right != null) {
            calculateSum(root.right);
        }

    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root.left == null && root.left.left == null && root.left.right == null) {
            return 0;
        }
        calculateSum(root);
        return totalSum;
    }

    //method2
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    public int sum(TreeNode root) {
      int sumLeft = 0;

      if (root.left != null) {
          if (isLeaf(root.left)) {
              sumLeft = root.left.val;
          } else {
              sumLeft = sum(root.left);
          }
      }
      if (root.right != null) {
          sumLeft += sum(root.right);
      }
      return sumLeft;
    }

    //method3
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root);
    }

    public boolean isLeafNode(TreeNode root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        else {
            boolean left = isLeafNode(root.left);
            boolean right = isLeafNode(root.right);
            if(left) totalSum += root.left.val;
            return false;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        isLeaf(root);
        return totalSum;
    }
}