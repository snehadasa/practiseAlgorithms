package LeetCode.Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
//    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
//    level by level from leaf to root).
//
//    For example:
//    Given binary tree [3,9,20,null,null,15,7],
//            3
//            / \
//            9  20
//            /  \
//            15   7
//            return its bottom-up level order traversal as:
//            [
//            [15,7],
//            [9,20],
//            [3]
//            ]

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> main = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> eachLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.poll();

                eachLevel.add(remove.val);

                if (remove.left != null) {
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    queue.add(remove.right);
                }
            }
            result.add(eachLevel);
        }
        for (int i = result.size()-1; i >= 0; i--) {
            main.add(result.get(i));
        }
        return main;
    }

    public void test1() {
        TreeNode root = new TreeNode();
        root.val = 5;
        root.left = new TreeNode();
        root.left.val = 10;
        root.right = new TreeNode();
        root.right.val = 8;
        root.left.left = new TreeNode();
        root.left.left.val = 50;
        root.right.right = new TreeNode();
        root.right.right.val = 100;
        System.out.println(levelOrderBottom(root));
    }

    public static void main(String[] args) {
        LevelOrderBottom treePaths = new LevelOrderBottom();
        treePaths.test1();
    }
}
