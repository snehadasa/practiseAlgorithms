package LeetCode.Easy.TreesSecondTime;


import LeetCode.Easy.Preorder;

import java.util.ArrayList;
import java.util.List;

public class PreOrderNArray {
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

    public List<Integer> addChildren(Node root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);

        for (Node child: root.children) {
            addChildren(child, res);
        }

        return res;
    }
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        addChildren(root, res);
        return res;
    }
}
