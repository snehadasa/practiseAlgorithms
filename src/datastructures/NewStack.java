package datastructures;

import java.util.ArrayList;

public class NewStack<T> {
    ArrayList<T> myList = new ArrayList<>();
    public boolean push(T value) {
        myList.add(value);
        return true;
    }

    public T pop() {
        return myList.remove(myList.size() - 1);
    }

    public int size() {
        return myList.size();
    }

    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public static void main(String[] args) {
        NewStack res = new NewStack();
        System.out.println(res.push(20));
        System.out.println(res.push(21));
        System.out.println(res.push(22));
        System.out.println(res.push(23));
        System.out.println(res.push(24));
        System.out.println(res.push(25));
        System.out.println(res.pop());
        System.out.println(res.size());
        System.out.println(res.isEmpty());
    }
}
