package LeetCode.Easy.TreesSecondTime;

import LeetCode.Easy.PostOrder;

import java.util.ArrayList;
import java.util.List;

public class PostOrderNTree {

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

    void childrenToList(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        //node.children.forEach(child -> childrenToList(node, res));
        for (Node child : node.children) {
            childrenToList(child, res);
            //res.add(child.val);
        }

    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        childrenToList(root, res);
        return res;
    }
}
