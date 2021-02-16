package LeetCode.Medium;

import LeetCode.Easy.DiameterOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
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

    public void bstToList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        bstToList(root.left, list);
        list.add(root.val);
        bstToList(root.right, list);
    }

    public TreeNode createBST(List<Integer> bst, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(bst.get(mid));
        node.left = createBST(bst, start, mid-1);
        node.right = createBST(bst, mid+1, end);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List tree = new ArrayList();
        bstToList(root, tree);
        return createBST(tree, 0, tree.size()-1);
    }
}
