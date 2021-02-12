package LeetCode.Easy;

import java.util.*;

public class FindTarget {
//    Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the
//    BST such that their sum is equal to the given target.
//
//
//
//            Example 1:
//
//
//    Input: root = [5,3,6,2,4,null,7], k = 9
//    Output: true
//    Example 2:
//
//
//    Input: root = [5,3,6,2,4,null,7], k = 28
//    Output: false
//    Example 3:
//
//    Input: root = [2,1,3], k = 4
//    Output: true
//    Example 4:
//
//    Input: root = [2,1,3], k = 1
//    Output: false
//    Example 5:
//
//    Input: root = [2,1,3], k = 3
//    Output: true
//
//
//    Constraints:
//
//    The number of nodes in the tree is in the range [1, 104].
//            -104 <= Node.val <= 104
//    root is guaranteed to be a valid binary search tree.
//            -105 <= k <= 105

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
    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(inOrderTraversal(root.left));
        res.add(root.val);
        res.addAll(inOrderTraversal(root.right));

        return res;
    }
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list = inOrderTraversal(root);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) != list.get(j) && list.get(i) + list.get(j) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list = inOrderTraversal(root);

        int left = 0, right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == k) {
                return true;
            }

            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public boolean findTarget3(TreeNode root, int k) {
        Set<Integer> toCheckIfValContains = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
           if (queue.peek() != null) {
               TreeNode remove = queue.remove();
               if (toCheckIfValContains.contains(k - remove.val))
                   return true;
               toCheckIfValContains.add(remove.val);
               queue.add(remove.right);
               queue.add(remove.left);
           } else
               queue.remove();
        }
        return false;
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
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
        System.out.println(findTarget(root, 9));
    }

    public static void main(String[] args) {
        FindTarget treePaths = new FindTarget();
        treePaths.test1();
    }
}
