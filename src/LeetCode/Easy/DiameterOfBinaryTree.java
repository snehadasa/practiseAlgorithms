package LeetCode.Easy;


public class DiameterOfBinaryTree {
//    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
//    is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//    Example:
//    Given a binary tree
//          1
//                  / \
//                  2   3
//                  / \
//                  4   5
//    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//    Note: The length of path between two nodes is represented by the number of edges between them.


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

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        int dia = leftH + rightH;
        return Math.max(dia, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    int ans;
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = depth(root.left);
        int ri = depth(root.right);
        ans = Math.max(ans, le+ri+1);
        return Math.max(le, ri) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
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
        root.left.left.right = new TreeNode();
        root.left.left.right.val = 100;
        System.out.println(diameterOfBinaryTree(root));
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree treePaths = new DiameterOfBinaryTree();
        treePaths.test1();
    }
}
