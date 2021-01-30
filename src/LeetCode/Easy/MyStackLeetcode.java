package LeetCode.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//    Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the
//    functions of a normal queue (push, top, pop, and empty).
//
//    Implement the MyStack class:
//
//    void push(int x) Pushes element x to the top of the stack.
//    int pop() Removes the element on the top of the stack and returns it.
//    int top() Returns the element on the top of the stack.
//    boolean empty() Returns true if the stack is empty, false otherwise.
//            Notes:
//
//    You must use only standard operations of a queue, which means only push to back, peek/pop from front, size,
//    and is empty operations are valid.
//    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or
//    deque (double-ended queue), as long as you use only a queue's standard operations.
//
//
//    Example 1:
//
//    Input
//["MyStack", "push", "push", "top", "pop", "empty"]
//        [[], [1], [2], [], [], []]
//    Output
//[null, null, null, 2, 2, false]
//
//    Explanation
//    MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
//
//
//    Constraints:
//
//            1 <= x <= 9
//    At most 100 calls will be made to push, pop, top, and empty.
//    All the calls to pop and top are valid.
//
//
//            Follow-up: Can you implement the stack such that each operation is amortized O(1) time complexity?
//    In other words, performing n operations will take overall O(n) time even if one of those operations may take
//    longer. You can use more than two queues.

class NodeForLeetcode {
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodeForLeetcode getNext() {
        return next;
    }

    public void setNext(NodeForLeetcode next) {
        this.next = next;
    }

    public NodeForLeetcode(int val) {
        this.val = val;
    }

    int val;
    NodeForLeetcode next;
}

class MyQueueForStackImpementation {
    NodeForLeetcode myList = null;
    NodeForLeetcode endPointerOfmyList = null;
    int count = 0;

    public void push(int val) {
        if (myList == null) {
            myList = new NodeForLeetcode(val);
            endPointerOfmyList = myList;
        } else {
            endPointerOfmyList.setNext(new NodeForLeetcode(val));
            endPointerOfmyList = endPointerOfmyList.getNext();
        }
        count++;
    }

    public int pop() {
        if (myList == null) {
            return 0;
        }

        NodeForLeetcode temp = myList;
        myList = myList.next;
        temp.next = null;
        count--;
        return temp.val;
    }

    public int top() {
        return myList.val;
    }

    public int size() {
        return count;
    }
    public boolean empty() {
        return (size() == 0);
    }
}
public class MyStackLeetcode {

    class MyStack {

        MyQueueForStackImpementation queueImple;
        /** Initialize your data structure here. */
        public MyStack() {
            queueImple = new MyQueueForStackImpementation();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queueImple.push(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queueImple.pop();
        }

        /** Get the top element. */
        public int top() {
            return queueImple.top();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queueImple.empty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
