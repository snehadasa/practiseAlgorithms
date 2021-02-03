package datastructures.Trees;

import java.util.*;

class TreeSecondTime<T> {
    private T value;
    private List<TreeSecondTime<T>> children;

    public T getValue() {
        return value;
    }

    public List<TreeSecondTime<T>> getChildren() {
        return children;
    }

    public TreeSecondTime(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public static <T> TreeSecondTime<T> of(T value) {
        return new TreeSecondTime<>(value);
    }

    public TreeSecondTime<T> addNewChild(T value) {
        TreeSecondTime<T> newChild = new TreeSecondTime<>(value);
        children.add(newChild);
        return newChild;
    }

}
public class BFSsecondTime {
    public static <T> Optional<TreeSecondTime<T>> bsfSearch(T value, TreeSecondTime<T> root) {
        Queue<TreeSecondTime<T>> queueForTree = new ArrayDeque<>();
        queueForTree.add(root);

        while (!queueForTree.isEmpty()) {
            TreeSecondTime<T> remove = queueForTree.poll();

            if (remove.getValue().equals(value)) {
                return Optional.of(remove);
            } else
                queueForTree.addAll(remove.getChildren());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        TreeSecondTime<Integer> root = TreeSecondTime.of(80);
        TreeSecondTime<Integer> firstChild = root.addNewChild(50);
        TreeSecondTime<Integer> firstSubChild = firstChild.addNewChild(40);
        TreeSecondTime<Integer> secondChild = root.addNewChild(90);
        TreeSecondTime<Integer> secondSubChildOfSecond = secondChild.addNewChild(95);
        Optional<TreeSecondTime<Integer>> found = BFSsecondTime.bsfSearch(95, root);
        System.out.println(found.isPresent() ? found.get().getValue() : "Dah! Dah! Dah! First Add The Value Before Searching For It");
    }
}
