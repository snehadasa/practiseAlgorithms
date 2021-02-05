package LeetCode.Easy.TreesSecondTime;

import LeetCode.Easy.BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    List<String> path = new ArrayList<>();


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

    public void addToPath(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            path.add(s + root.val);
        }
        if (root.left == null) {
            addToPath(root.right, "" + s + root.val + "->");
            return;
        }
        if (root.right == null) {
            addToPath(root.left, "" + s + root.val + "->");
            return;
        }
        addToPath(root.left, "" + s + root.val + "->");
        addToPath(root.right, "" + s + root.val + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return path;
        }
        addToPath(root, "");
        return path;
    }
}
