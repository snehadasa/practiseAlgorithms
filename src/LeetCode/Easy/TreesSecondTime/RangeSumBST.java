package LeetCode.Easy.TreesSecondTime;

import datastructures.Stack;

public class RangeSumBST {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) return 0;
        if (root.val <= low && root.val >= high) {
            sum += root.val;
        }
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode remove = stack.pop();
            if (remove.val <= low && remove.val >= high) {
                sum += remove.val;
            }
            if (remove.val > low && remove.left != null) {
                stack.push(remove.left);
            }
            if (remove.val < high && remove.right != null) {
                stack.push(remove.right);
            }
        }
        return sum;
    }
}
