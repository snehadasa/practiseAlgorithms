package LeetCode.Easy.TreesSecondTime;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
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

    public List<TreeNode> inorderTraversalForBST(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversalForBST(root.left));
        res.add(root);
        res.addAll(inorderTraversalForBST(root.right));

        return res;
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> sortedBST = inorderTraversalForBST(root);

        if (root == null) {
            return null;
        }
        for (int i = 0; i < sortedBST.size(); i++) {
            sortedBST.get(i).left = null;
            sortedBST.get(i).right = sortedBST.get(i+1);
        }
        sortedBST.get(sortedBST.size()-1).left = null;
        sortedBST.get(sortedBST.size()-1).right = null;

        return sortedBST.get(0);
    }
}
