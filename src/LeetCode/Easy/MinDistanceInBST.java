package LeetCode.Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinDistanceInBST {
//    Given the root of a Binary Search Tree (BST), return the minimum difference between the values of
//    any two different nodes in the tree.
//
//    Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
//
//
//
//    Example 1:
//
//
//    Input: root = [4,2,6,1,3]
//    Output: 1
//    Example 2:
//
//
//    Input: root = [1,0,48,null,null,12,49]
//    Output: 1
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [2, 100].
//            0 <= Node.val <= 105

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

    public int minDiffInBST1(TreeNode root) {
       Queue<TreeNode> queue = new ArrayDeque<>();
       queue.add(root);
       int minResult = -1;
       List<Integer> res = new ArrayList<>();

       while (!queue.isEmpty()) {
           TreeNode remove = queue.poll();

           if (remove.left != null) {
               if (minResult == -1 || minResult > (remove.val - remove.left.val)) {
                   minResult = remove.val - remove.left.val;
                   res.add(minResult);
               }
               queue.add(remove.left);
           }

           if (remove.right != null) {
               if (minResult == -1 || minResult > (remove.right.val - remove.val)) {
                   minResult = remove.right.val - remove.val;
                   res.add(minResult);
               }
               queue.add(remove.right);
           }
       }

       for (int i = 0; i < res.size(); i++) {
           minResult = Math.min(minResult, res.get(i));
       }
       return minResult;
    }


    public int minDiffInBST(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> allNodes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.poll();

            allNodes.add(remove.val);

            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }
        }

        for (int i = 0; i < allNodes.size(); i++) {
            for (int j = 0; j < allNodes.size(); j++) {
                if (allNodes.get(i) > allNodes.get(j)) {
                    result.add(allNodes.get(i) - allNodes.get(j));
                }
            }
        }

        int min = result.get(0);
        for (int i = 0; i < result.size(); i++) {
            min = Math.min(min, result.get(i));
        }
        return min;
    }

}
