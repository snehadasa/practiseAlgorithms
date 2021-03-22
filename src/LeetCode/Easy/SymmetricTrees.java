package LeetCode.Easy;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTrees {
//    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//
//
//    Example 1:
//
//
//    Input: root = [1,2,2,3,4,4,3]
//    Output: true
//    Example 2:
//
//
//    Input: root = [1,2,2,null,3,null,3]
//    Output: false
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [1, 1000].
//            -100 <= Node.val <= 100
//
//
//    Follow up: Could you solve it both recursively and iteratively?

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

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = depth(root.left);
        int ri = depth(root.right);
        int ans = 0;
        ans = Math.max(ans, le + ri + 1);
        return Math.max(le, ri) + 1;
    }

    public boolean isSymettricTwoTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1 != null && root2 != null) && (root1.val == root2.val) &&
                isSymettricTwoTrees(root1.left, root2.right) && isSymettricTwoTrees(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymettricTwoTrees(root.left, root.right);
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
