package datastructures;

import java.util.EmptyStackException;

class NodeNew<T> {
    T value;
    NodeNew next;

    public NodeNew(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public NodeNew getNext() {
        return next;
    }

    public void setNext(NodeNew next) {
        this.next = next;
    }
}
public class NewQueue<T> {
    NodeNew<T> myList = null;
    NodeNew<T> pointerToEndNode = null;
    int count = 0;

    public boolean add(T value) {
        NodeNew<T> temp;

        if (myList == null) {
            myList = new NodeNew<>(value);
            pointerToEndNode = myList;
        } else {
//            temp = myList;
//            if (temp.next == null) {
//                temp = temp.next;
//            }
//            temp.setNext(new NodeNew(value));
            pointerToEndNode.setNext(new NodeNew(value));
            pointerToEndNode = pointerToEndNode.getNext();
        }
        count++;
        return true;
    }

    public T poll() throws Exception {
        NodeNew<T> temp;

        if (myList == null) {
            throw new EmptyStackException();
        }

        temp = myList;
        myList = myList.getNext();
        temp.next = null;
        count--;
        return temp.getValue();
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public static void main(String[] args) throws Exception {
        NewQueue res = new NewQueue();
        System.out.println(res.add(41));
        System.out.println(res.add(42));
        System.out.println(res.add(43));
        System.out.println(res.add(44));
        System.out.println(res.add(45));
        System.out.println(res.add(46));
        System.out.println(res.add(47));
        System.out.println(res.add(48));
        System.out.println(res.add(49));
        System.out.println(res.add(50));
        System.out.println(res.poll());
        System.out.println(res.poll());
        System.out.println(res.poll());
        System.out.println(res.poll());
        System.out.println(res.poll());
        System.out.println(res.size());
        System.out.println(res.isEmpty());
    }
}
