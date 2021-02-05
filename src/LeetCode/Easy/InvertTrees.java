package LeetCode.Easy;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InvertTrees {
//    Invert a binary tree.
//
//    Example:
//
//    Input:
//
//            4
//            /   \
//            2     7
//            / \   / \
//            1   3 6   9
//    Output:
//
//            4
//            /   \
//            7     2
//            / \   / \
//            9   6 3   1
//    Trivia:
//    This problem was inspired by this original tweet by Max Howell:
//
//    Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a
//    binary tree on a whiteboard so f*** off.

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

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        left = root.right;
        right = root.left;
        return root;
    }
}