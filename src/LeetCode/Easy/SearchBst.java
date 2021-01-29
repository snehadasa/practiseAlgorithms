package LeetCode.Easy;

import javax.swing.tree.TreeNode;

public class SearchBst {
//    Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the
//    node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist,
//    you should return NULL.
//
//            For example,
//
//    Given the tree:
//            4
//            / \
//            2   7
//            / \
//            1   3
//
//    And the value to search: 2
//    You should return this subtree:
//
//            2
//            / \
//            1   3
//    In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
//
//    Note that an empty tree is represented by NULL, therefore you would see the expected output
//            (serialized tree format) as [], not null.


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
       if (root == null || root.val == val) {
           return root;
       }

       if (root.val > val) {
           return searchBST(root.left, val);
       } else
           return searchBST(root.right, val);
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == val) {
                return temp;
            }
            else if (temp.val > val) {
                temp = temp.left;
            } else
                temp = temp.right;
        }
        return temp;
    }
}
