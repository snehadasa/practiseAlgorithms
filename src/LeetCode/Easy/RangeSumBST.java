package LeetCode.Easy;

import com.sun.source.tree.BinaryTree;


//    Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
//
//
//
//    Example 1:
//
//
//    Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
//    Output: 32
//    Example 2:
//
//
//    Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//    Output: 23
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [1, 2 * 104].
//            1 <= Node.val <= 105
//            1 <= low <= high <= 105
//    All Node.val are unique.


public class RangeSumBST {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
       int sum = 0;
       if (root.val >= low && root.val <= high) {
           sum += root.val;
       }

       if (low < root.val) {
           sum += rangeSumBST(root.left, low, high);
       } else
           sum += rangeSumBST(root.right, low, high);

       return sum;
    }


//    public static void main(String[] args) {
//
//        RangeSumBST res = new RangeSumBST();
//        TreeNode root = new TreeNode(5);
//        TreeNode left = new TreeNode<>(4);
//        TreeNode<> right = new TreeNode<>(10);
//        root.left(left);
//        root.right( right);
//        left.left(new TreeNode(2));
//        left.right(new TreeNode(20));
//        right.left(new TreeNode(40));
//        right.right(new TreeNode(80));
//        right.right().setRightNode(new TreeNode(100));
//        //Integer[] root = {10, 5, 15, 3, 7, null, 18};
//        System.out.println(res.rangeSumBST(root, 7, 15));
//    }

}
