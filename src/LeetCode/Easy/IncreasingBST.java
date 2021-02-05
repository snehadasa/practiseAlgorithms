package LeetCode.Easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreasingBST {
//    Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost TreeNode in the tree
//    is now the root of the tree, and every TreeNode has no left child and only one right child.
//
//
//
//            Example 1:
//
//
//    Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//    Example 2:
//
//
//    Input: root = [5,1,7]
//    Output: [1,null,5,null,7]
//
//
//    Constraints:
//
//    The number of TreeNodes in the given tree will be in the range [1, 100].
//            0 <= TreeNode.val <= 1000

    class TreeNode {
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

    public List<TreeNode> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> res = new ArrayList<>();
        res.addAll(inorderTraversal(root.left));
        res.addAll(inorderTraversal(root));
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    public TreeNode increasingBSt(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> sortedBST = inorderTraversal(root);
        for (int i = 0; i < sortedBST.size()-1; i++) {
            sortedBST.get(i).left = null;
            sortedBST.get(i).right = sortedBST.get(i+1);
        }
        sortedBST.get(sortedBST.size()-1).left = null;
        sortedBST.get(sortedBST.size()-1).right = null;
        return sortedBST.get(0);
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
        System.out.println(increasingBSt(root));
    }

    public static void main(String[] args) {
        BinaryTreePaths increasingBstVal = new BinaryTreePaths();
        increasingBstVal.test1();
    }
}
