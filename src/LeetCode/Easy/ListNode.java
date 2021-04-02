package LeetCode.Easy;

import javax.swing.plaf.basic.BasicListUI;
import java.util.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode mergeLists(ListNode a, ListNode b) {
       ListNode res = null;

       ListNode iterA = a, iterB = b;

       while (iterA != null && iterB != null) {
           if (res == null) {
               res = iterA;
           } else {
               res.next = iterA;
               res = res.next;
           }
           res.next = iterB;
           res = res.next;
           iterA = iterA.next;
           iterB = iterB.next;
       }

       if (iterA != null) {
           res.next = iterA;
       }
       if (iterB != null) {
           res.next = iterB;
       }

       return res;
    }



}
