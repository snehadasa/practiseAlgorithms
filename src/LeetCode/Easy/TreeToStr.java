package LeetCode.Easy;

public class TreeToStr {
//    You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//
//    The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty
//    parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
//
//    Example 1:
//    Input: Binary tree: [1,2,3,4]
//            1
//            /   \
//            2     3
//            /
//            4
//
//    Output: "1(2(4))(3)"
//
//    Explanation: Originallay it needs to be "1(2(4)())(3()())",
//    but you need to omit all the unnecessary empty parenthesis pairs.
//    And it will be "1(2(4))(3)".
//    Example 2:
//    Input: Binary tree: [1,2,3,null,4]
//            1
//            /   \
//            2     3
//            \
//            4
//
//    Output: "1(2()(4))(3)"
//
//    Explanation: Almost the same as the first example,
//    except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

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


    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int val = t.val;
        res.append(val);
        if (t.left == null && t.right == null) {
            return res.toString();
        }
        //if (t.left != null) {
            res.append("(");
            res.append(tree2str(t.left));
            res.append(")");
       // }
        if (t.right != null) {
            res.append("(");
            res.append(tree2str(t.right));
            res.append(")");
        }
        return res.toString();

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
//        root.right.right = new TreeNode();
//        root.right.right.val = 100;
        System.out.println(tree2str(root));
    }

    public static void main(String[] args) {
        TreeToStr treePaths = new TreeToStr();
        treePaths.test1();
    }
}
