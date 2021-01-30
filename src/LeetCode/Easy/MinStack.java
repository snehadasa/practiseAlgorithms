package LeetCode.Easy;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
//
//
//        Example 1:
//
//        Input
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]
//
//        Output
//        [null,null,null,null,-3,null,0,-2]
//
//        Explanation
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin(); // return -3
//        minStack.pop();
//        minStack.top();    // return 0
//        minStack.getMin(); // return -2
//
//
//        Constraints:
//
//        Methods pop, top and getMin operations will always be called on non-empty stacks.

import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> myList;
    /** initialize your data structure here. */
    public MinStack() {
        myList = new ArrayList<>();
    }

    public void push(int x) {
        myList.add(x);
    }

    public void pop() {
        myList.remove(myList.size() - 1);
    }

    public int top() {
        if (myList == null) {
            return 0;
        }
        return myList.get(myList.size()-1);
    }

    public int getMin() {
        int min = myList.get(0);
        for (int i = 0; i < myList.size(); i++) {
            min = Math.min(min, myList.get(i));
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

