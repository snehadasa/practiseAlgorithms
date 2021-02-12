package LeetCode.Easy;

import java.util.*;

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

        boolean isLeaf() {
            return left == null ? right == null : false;
        }
    }


    public List<Double> countZeros1(TreeNode root) {
       if (root == null) {
           return null;
       }
        List<Double> result = new ArrayList<>();
       Queue<TreeNode> queue = new ArrayDeque<>();   //add all elements to a queue
       queue.add(root);

       while (!queue.isEmpty()) {
           List<TreeNode> countNodesInEachLevel = new ArrayList<>();  //list to add count of elements ineach level
           double sum = 0;

           while (!queue.isEmpty()) {    //elements that are removed from queue in each level are added to list.
               countNodesInEachLevel.add(queue.poll());  //By this we can determine number of elements in each level.
           }

           for (TreeNode temp: countNodesInEachLevel) {
               if (temp.left != null) {
                   queue.add(temp.left);
               }
               if (temp.right != null) {
                   queue.add(temp.right);
               }
               sum += root.val;
           }
           result.add(sum / countNodesInEachLevel.size());
       }
       return result;
    }

    public List<Double> countZeros(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0, count = 0;
            Queue<TreeNode> countQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode poppedElement = queue.poll();
                sum += poppedElement.val;
                count++;
                if (poppedElement.left != null) {
                    countQueue.add(poppedElement.left);
                }
                if (poppedElement.right != null) {
                    countQueue.add(poppedElement.right);
                }
            }
            queue = countQueue;
            result.add(sum / count);
        }
        return result;
    }

}
