package datastructures.Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTreeTraversal {
    //private static NodeForBFS root;
    // Level order traversal of a tree is breadth first traversal for the tree.

    static class NodeForBFS {
        int val;
        NodeForBFS left, right;

        public NodeForBFS(int val) {
            this.val = val;
            left = right = null;
        }
    }

//    public boolean printLevel(NodeForBFS root, int level) {
//        if (root == null) {
//            return false;
//        }
//
//        if (level == 1) {
//            System.out.println(root.val + " ");
//            return true;
//        }
//
//        boolean left = printLevel(root.left, level-1);
//        boolean right = printLevel(root.right, level-1);
//
//        return left || right;
//    }
//
//    public void levelOrderTraversal1(NodeForBFS root) {
//        int level = 1;
//
//        while (printLevel(root, level)) {
//            level++;
//        }
//    }

    public void levelOrderTraversal(NodeForBFS root) {
        Queue<NodeForBFS> queue = new ArrayDeque<>();

        queue.add(root);
        NodeForBFS remove;

        while (!queue.isEmpty()) {
            remove = queue.poll();
            System.out.print(remove.val + " ");

            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }
        }
    }

        public static void main(String[] args) {

        NodeForBFS root = new NodeForBFS(15);
        root.left = new NodeForBFS(10);
        root.right = new NodeForBFS(20);
        root.left.left = new NodeForBFS(8);
        root.left.right = new NodeForBFS(12);
        root.right.left = new NodeForBFS(16);
        root.right.right = new NodeForBFS(25);

        LevelOrderTreeTraversal res = new LevelOrderTreeTraversal();
        res.levelOrderTraversal(root);
    }
}
