package LeetCode.Easy;

import java.util.LinkedList;

public class GetDecimalValue {
//    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either
//    0 or 1. The linked list holds the binary representation of a number.
//
//    Return the decimal value of the number in the linked list.
//
//
//
//            Example 1:
//
//
//    Input: head = [1,0,1]
//    Output: 5
//    Explanation: (101) in base 2 = (5) in base 10
//    Example 2:
//
//    Input: head = [0]
//    Output: 0
//    Example 3:
//
//    Input: head = [1]
//    Output: 1
//    Example 4:
//
//    Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//    Output: 18880
//    Example 5:
//
//    Input: head = [0,0]
//    Output: 0
//
//
//    Constraints:
//
//    The Linked List is not empty.
//    Number of nodes will not exceed 30.
//    Each node's value is either 0 or 1.

    public int getDecimalValue(ListNode head) {
        // Calculating length of linked list.
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int sum = 0;
        temp = head;
        for (int i = length - 1; i >= 0; i--) {
            sum += Math.pow(2, i) * temp.val;
            temp = temp.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        GetDecimalValue res = new GetDecimalValue();
        ListNode head = new ListNode(1);
        ListNode secondNode = new ListNode(0);
        ListNode thirdNode = new ListNode(1);
        ListNode fourthNode = new ListNode(0);
        head.next = secondNode;
        secondNode.next  = thirdNode;
        thirdNode.next = fourthNode;

        System.out.println(res.getDecimalValue(head));
    }
}
