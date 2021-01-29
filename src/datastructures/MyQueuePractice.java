package datastructures;

import jdk.jshell.spi.ExecutionControl;

import java.util.EmptyStackException;

class Node<T> {
    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    Node next;
    T value;
}

class MyQueue<T> {

    Node<T> myList = null;
    Node<T> endPointerOfMyList = null;
    int count = 0;

    public boolean add(T value) {
         Node<T> temp;
        if (myList == null) {
            myList = new Node(value);
            endPointerOfMyList = myList;
        } else {
//            temp  = myList;
//            while(temp.next == null) {
//                temp = temp.next;
//            }
//            temp.setNext(new Node(value));
            endPointerOfMyList.setNext(new Node(value));
            endPointerOfMyList = endPointerOfMyList.getNext();
        }
        count++;
        return true;
    }

    public T poll() throws Exception{
        if (myList == null) {
            throw new EmptyStackException();
        }

        Node<T> temp = myList;
        myList = myList.getNext(); //changing the head of myList to next element.
        temp.next = null;  //setting the link of temp to null
        count--;
        return temp.getValue();  //deleted node from the list
    }

    public int size() {
//        int count = 0;
//        Node temp = myList;
//        while (temp != null) {
//            count++;
//            temp = temp.next;
//        }
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }


}
