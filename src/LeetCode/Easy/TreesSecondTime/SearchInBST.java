package LeetCode.Easy.TreesSecondTime;


import java.util.ArrayDeque;
import java.util.Queue;

public class SearchInBST {
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

    public TreeNode searchBST(TreeNode root, int val) {
       if (root == null) {
           return null;
       }
       TreeNode temp = root;
       while (temp != null) {
           if (temp.val == val) {
               return temp;
           }
           if (temp.val > val) {
               temp = temp.left;
           } else
               temp = temp.right;
       }
       return temp;
    }
}
