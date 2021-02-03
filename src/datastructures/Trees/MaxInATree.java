package datastructures.Trees;

import LeetCode.Easy.BinaryTreePaths;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxInATree {
    public class TreeNode {
        int val;
        int maxInSubtree = 0;  //variable to get max in each subtree
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

    //get max in entire tree
    public int getMax(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()) {
           TreeNode temp = queue.poll();

            if (temp.val > max) {
                max = temp.val;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return max;
    }

    public int getMax1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.val, Math.max(getMax1(root.left), getMax1(root.right)));
    }

    //get max in each subtree
    public int popualateMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.maxInSubtree = Math.max(root.val, Math.max(getMax1(root.left), getMax1(root.right)));
        return root.maxInSubtree;
    }

    public void test1() {
        TreeNode root = new TreeNode();
        root.val = 5;
        root.left = new TreeNode();
        root.left.val  = 10;
        root.right = new TreeNode();
        root.right.val = 8;
        root.left.left = new TreeNode();
        root.left.left.val = 50;
        root.right.right = new TreeNode();
        root.right.right.val = 100;
        System.out.println((root.left));
    }

    public static void main(String[] args) {
        BinaryTreePaths treePaths = new BinaryTreePaths();
        treePaths.test1();
    }
}
