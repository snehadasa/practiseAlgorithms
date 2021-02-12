package LeetCode.Easy;

public class SortedArrayToBST {
//    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
//    subtrees of every node never differ by more than 1.
//
//    Example:
//
//    Given the sorted array: [-10,-3,0,5,9],
//
//    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//            0
//            / \
//            -3   9
//            /   /
//            -10  5

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

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int index = 0;
            TreeNode root = new TreeNode();
            if (index < nums.length) {
                root = new TreeNode(index);

                root.left = sortedArrayToBST(nums);
                root.right = sortedArrayToBST(nums);
            }
            return root;
        }
    }
}
