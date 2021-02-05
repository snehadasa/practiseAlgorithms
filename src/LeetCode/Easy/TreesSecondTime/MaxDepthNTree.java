package LeetCode.Easy.TreesSecondTime;


import java.util.List;

public class MaxDepthNTree {
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

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child: root.children) {
            max = Math.max(max, 1+height(child));
        }
        return max;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root)+1;
    }
}
