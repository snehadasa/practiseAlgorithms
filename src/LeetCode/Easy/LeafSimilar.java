package LeetCode.Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeafSimilar {
//    Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//
//
//
//    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//    Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//            Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
//
//            Example 1:
//
//
//    Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
//    Output: true
//    Example 2:
//
//    Input: root1 = [1], root2 = [1]
//    Output: true
//    Example 3:
//
//    Input: root1 = [1], root2 = [2]
//    Output: false
//    Example 4:
//
//    Input: root1 = [1,2], root2 = [2,2]
//    Output: true
//    Example 5:
//
//
//    Input: root1 = [1,2,3], root2 = [1,3,2]
//    Output: false
//
//
//    Constraints:
//
//    The number of nodes in each tree will be in the range [1, 200].
//    Both of the given trees will have values in the range [0, 200].

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

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        Queue<TreeNode> queueRoot1 = new ArrayDeque<>();
        Queue<TreeNode> queueRoot2 = new ArrayDeque<>();

//        if (depth(root1) == 1 && depth(root2) == 1) {
//            queueRoot1.add(root1);
//            queueRoot2.add(root2);
//        }
        while (!queueRoot1.isEmpty() && !queueRoot2.isEmpty()) {
            List<TreeNode> list1 = new ArrayList<>();
            List<TreeNode> list2 = new ArrayList<>();
            while (!queueRoot1.isEmpty() && !queueRoot2.isEmpty()) {
                if (depth(root1) > 1 && depth(root2) > 1) {
                    if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
                        list1.add(queueRoot1.poll());
                        list2.add(queueRoot2.poll());
                    }
                }
//                else {
//                    list1.add(queueRoot1.poll());
//                    list2.add(queueRoot2.poll());
//                }
            }
            if (list1 != list2) {
                return false;
            }
        }
        return true;
    }

    public void addToList(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        addToList(root.left, res);
        addToList(root.right, res);
    }
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
//        if (root1 == null && root2 == null) {
//            return true;
//        }
//        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            addToList(root1,list1);
            addToList(root2,list2);
        //}
        return list1.equals(list2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}