package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class AverageInBinaryTrees {
//    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//            Example 1:
//    Input:
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    Output: [3, 14.5, 11]
//    Explanation:
//    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//    Note:
//    The range of node's value is in the range of 32-bit signed integer.

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

    int ans;
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //ans = Math.max(ans, Math.max(depth(root.left), depth(root.right)));
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int avg = 0;
        for (int i = 0; i < depth(root); i++) {
            avg = averageOfLevels(root.left) + averageOfLevels(root.right) /
        }
    }
}
