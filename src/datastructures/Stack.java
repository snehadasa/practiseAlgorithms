package datastructures;

import java.util.ArrayList;

public class Stack<T> {
    public int size() {
        return myList.size();
    }

    public boolean push(T value) {
        myList.add(value);
        return true;
    }

    public T pop() {
        return myList.remove(myList.size() - 1);
    }

    public boolean isEmpty() {
        return myList.isEmpty();
    }


    ArrayList<T> myList  = new ArrayList<>();
}
