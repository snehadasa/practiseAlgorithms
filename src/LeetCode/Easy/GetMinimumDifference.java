package LeetCode.Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GetMinimumDifference {
//    Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
//
//    Example:
//
//    Input:
//
//            1
//            \
//            3
//            /
//            2
//
//    Output:
//            1
//
//    Explanation:
//    The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
//
//
//    Note:
//
//    There are at least two nodes in this BST.
//    This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

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

    // It contains max, min , min diff of both
//    List<Integer> getMinDiff(TreeNode root) {
//        List<Integer> diff = new ArrayList<>();
//        if (root == null) {
//            return diff;
//        }
//        int minDiff  = Integer.MAX_VALUE;
//        int min  = root.val;
//        int max  = root.val;
//
//        if (root.left == null && root.right == null) {
//            diff.add(max); // max
//            diff.add(min); // min
//            diff.add(minDiff); // mindiff
//        }
//
//        if (root.left != null) {
//            List<Integer> leftValues = getMinDiff(root.left);
//            minDiff = Math.min(root.val - leftValues.get(0), minDiff);
//            minDiff = Math.min(minDiff, leftValues.get(2));
//        }
//        if (root.right != null) {
//
//        }
//    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.poll();

            list1.add(remove.val);
            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (list1.get(i) > list1.get(j)) {
                    list2.add(list1.get(i) - list2.get(j));
                }
            }
        }

        int minVal = 0;
        for (int i = 0; i < list2.size(); i++) {
            minVal = Math.min(minVal, list2.get(i));
        }
        return minVal;
    }
}
