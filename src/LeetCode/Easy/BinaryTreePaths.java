package LeetCode.Easy;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreePaths {
//    Given a binary tree, return all root-to-leaf paths.
//
//    Note: A leaf is a node with no children.
//
//    Example:
//
//    Input:
//
//            1
//            /   \
//            2     3
//            \
//            5
//
//    Output: ["1->2->5", "1->3"]
//
//    Explanation: All root-to-leaf paths are: 1->2->5, 1->3

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

    List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
       if (root == null) {
           return path;
       }
       addToPath(root, "");
       return path;
    }

    public void addToPath(TreeNode node, String s) {
        if (node.left == null && node.right == null) {
            path.add(s+node.val);
            return;
        }
        if (node.left == null) {
            addToPath(node.right, ""+s+node.val+"->");
            return;
        }
        if (node.right == null) {
            addToPath(node.left, ""+s+node.val+"->");
            return;
        }
        addToPath(node.left, ""+s+node.val+"->");
        addToPath(node.right, ""+s+node.val+"->");
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
        System.out.println((path));
    }

    public static void main(String[] args) {
        BinaryTreePaths treePaths = new BinaryTreePaths();
        treePaths.test1();
    }
}
