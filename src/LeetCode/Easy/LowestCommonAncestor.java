package LeetCode.Easy;

//    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
//    as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//
//
//    Example 1:
//
//
//    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//    Output: 6
//    Explanation: The LCA of nodes 2 and 8 is 6.
//    Example 2:
//
//
//    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//    Output: 2
//    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//    Example 3:
//
//    Input: root = [2,1], p = 2, q = 1
//    Output: 2
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [2, 105].
//            -109 <= Node.val <= 109
//    All Node.val are unique.
//            p != q
//    p and q will exist in the BST.


import java.util.ArrayDeque;
import java.util.Queue;

    public class LowestCommonAncestor {
//    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
//    as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//
//
//    Example 1:
//
//
//    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//    Output: 6
//    Explanation: The LCA of nodes 2 and 8 is 6.
//    Example 2:
//
//
//    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//    Output: 2
//    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//    Example 3:
//
//    Input: root = [2,1], p = 2, q = 1
//    Output: 2
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [2, 105].
//            -109 <= Node.val <= 109
//    All Node.val are unique.
//            p != q
//    p and q will exist in the BST.

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }


        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (p.val == q.val) {
                return null;
            }
            if (p.val == root.val || q.val == root.val) {
                return root;
            }
            if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
                return root;
            }
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor1(root.left, p, q);
            } else {
                return lowestCommonAncestor1(root.right, p, q);
            }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode remove = queue.poll();
//
//            if (remove == p && remove == q) {
//                if (p.val )
//            }
//        }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            TreeNode node = root;

            while (node != null) {
                if (p.val < node.val && q.val < node.val) {
                    node = node.left;
                }
                else if (p.val > node.val && q.val > node.val) {
                    node = node.right;
                } else
                    return node;
            }
            return null;
        }
}
