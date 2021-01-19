package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode<T> {

    public TreeNode(T value) {
        this.value = value;
    }

    public T getNodeValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    private T value;
    private TreeNode leftNode;
    private TreeNode rightNode;
}

public class TreeTraversal {

   public static<T> List<T> preOrderTraversal(TreeNode root) {
       List<T> result = new LinkedList<>();
       TreeNode<T> temp;
       Queue<TreeNode<T>> queue = new LinkedList<>();

       queue.add(root);
       int count = 0;
       while (!queue.isEmpty()) {
           Queue<TreeNode<T>> tempQueue = new LinkedList<>();
           while (!queue.isEmpty()) {
               temp = queue.poll();

               result.add(temp.getNodeValue());
               if (temp.getLeftNode() != null) {
                   tempQueue.add(temp.getLeftNode());
               }
               if (temp.getRightNode() != null) {
                   tempQueue.add(temp.getRightNode());
               }
           }
           count++;
           queue = tempQueue;
       }

       System.out.println("Count: " + count);
       return result;
   }

   public static<T> List<T> inOrderTraversal(TreeNode<T> root) {
       if (root == null) {
           return new ArrayList<>();
       }
       List<T> res = new ArrayList<>();
       res.addAll(inOrderTraversal(root.getLeftNode()));
       res.add(root.getNodeValue());
       res.addAll(inOrderTraversal(root.getRightNode()));

       return res;
   }

   public static<T> List<T> postOrdertraversal(TreeNode<T> root) {
       if (root == null) {
           return new ArrayList<>();
       }
       List<T> result = new ArrayList<>();
       result.addAll(postOrdertraversal(root.getLeftNode()));
       result.addAll(postOrdertraversal(root.getRightNode()));
       result.add(root.getNodeValue());

       return result;
   }

   public  static<T> int calculateDepth(TreeNode<T> node) {
       if (node == null) {
           return 0;
       }
       return Math.max(calculateDepth(node.getLeftNode()), calculateDepth(node.getRightNode())) + 1;
   }

    public  static int calculateSum(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        return node.getNodeValue() + calculateSum(node.getLeftNode()) + calculateSum((node.getRightNode()));
    }

    public static void main(String []args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> left = new TreeNode<>(4);
        TreeNode<Integer> right = new TreeNode<>(10);
        root.setLeftNode(left);
        root.setRightNode( right);
        left.setLeftNode(new TreeNode(2));
        left.setRightNode(new TreeNode(20));
        right.setLeftNode(new TreeNode(40));
        right.setRightNode(new TreeNode(80));
        right.getRightNode().setRightNode(new TreeNode(100));

        System.out.println(preOrderTraversal(root));
        System.out.println(inOrderTraversal(root));
        System.out.println(postOrdertraversal(root));
    }
}