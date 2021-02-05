package LeetCode.Easy;


import java.util.ArrayList;
import java.util.List;

public class IsUnivalTree {
//    A binary tree is univalued if every node in the tree has the same value.
//
//            Return true if and only if the given tree is univalued.
//
//
//
//            Example 1:
//
//
//    Input: [1,1,1,1,1,null,1]
//    Output: true
//    Example 2:
//
//
//    Input: [2,2,2,5,2]
//    Output: false
//
//
//    Note:
//
//    The number of nodes in the given tree will be in the range [1, 100].
//    Each node's value will be an integer in the range [0, 99].


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



    public static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(inOrderTraversal(root.left));
        res.add(root.val);
        res.addAll(inOrderTraversal(root.right));

        return res;
    }
    public boolean isUnivalTree1(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<Integer> sortedVal = inOrderTraversal(root);
        for (int i = 0; i < sortedVal.size(); i++) {
            if (sortedVal.get(i).equals(sortedVal.get(i+1))) {
                return true;
            }
        }
//        if (root.left.val == root.right.val) {
//            value = root.left.val;b
//        }
//        if (value == root.val) {
//            return true;
//        }
        return false;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
