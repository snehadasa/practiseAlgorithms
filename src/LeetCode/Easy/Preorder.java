package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
//    Given an n-ary tree, return the preorder traversal of its nodes' values.
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
//    Output: [1,3,5,6,2,4]
//    Example 2:
//
//
//
//    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
//    Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//
//
//    Constraints:
//
//    The height of the n-ary tree is less than or equal to 1000
//    The total number of nodes is between [0, 10^4]
//

    // Definition for a Node.
    public class Node {
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
    void childrenToList(Node node, List<Integer> ans) {
        if (node == null) return;
        ans.add(node.val);
        node.children.forEach(child -> childrenToList(child, ans));
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        childrenToList(root, result);
        return result;
    }

        //method2
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return res;

        res.add(root.val);
        for (Node node:root.children) {
            preorder(node);
        }
        return res;
    }

    //iterative approach
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node != null) {
                result.add(node.val);
            } else {
                continue;
            }
            if (node.children == null || node.children.size() == 0) {
                continue;
            }
            int size = node.children.size();
            for (int i = size - 1; i >= 0; i--) {
                Node child = node.children.get(i);
                stack.push(child);
            }
        }

        return result;
    }
}
