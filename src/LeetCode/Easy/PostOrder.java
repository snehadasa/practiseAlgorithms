package LeetCode.Easy;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
//    Given an n-ary tree, return the postorder traversal of its nodes' values.
//
//    Nary-Tree input serialization is represented in their level order traversal, each group of children is separated
//    by the null value (See examples).
//
//
//
//    Follow up:
//
//    Recursive solution is trivial, could you do it iteratively?
//
//
//
//    Example 1:
//
//
//
//    Input: root = [1,null,3,2,4,null,5,6]
//    Output: [5,6,3,2,4,1]
//    Example 2:
//
//
//
//    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//    Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
//
//
//    Constraints:
//
//    The height of the n-ary tree is less than or equal to 1000
//    The total number of nodes is between [0, 10^4]


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //method 1
    void childrenToList(Node node, List<Integer> res) {
        if (node == null) return;

        res.add(node.val);
        node.children.forEach(child -> childrenToList(child, res));
    }
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        childrenToList(root, res);
        return res;
    }

    //method 2
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return result;

        for (Node node: root.children) {
            postorder(node);
        }
        result.add(root.val);

        return result;
    }

    public static void main(String[] args) {

    }
}