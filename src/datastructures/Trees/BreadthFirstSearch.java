package datastructures.Trees;

import java.util.*;

class Tree<T> {
    public T getValue() {
        return value;
    }

    private T value;

    public List<Tree<T>> getChildren() {
        return children;
    }

    private List<Tree<T>> children;

    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    public static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }
    public Tree<T> addNewChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

}
public class BreadthFirstSearch {
    public static <T> Optional<Tree<T>> bfs(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree<T> removeCurentNode = queue.remove();

            if (removeCurentNode.getValue().equals(value)) {
                return Optional.of(removeCurentNode);
            } else {
                queue.addAll(removeCurentNode.getChildren());
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> firstChild = root.addNewChild(2);
        Tree<Integer> depthMostChild = firstChild.addNewChild(3);
        Tree<Integer> secondChild = root.addNewChild(4);
        Optional<Tree<Integer>> found = BreadthFirstSearch.bfs(7, root);
        System.out.println(found.isPresent() ? found.get().getValue() : "No element found");
    }
}
