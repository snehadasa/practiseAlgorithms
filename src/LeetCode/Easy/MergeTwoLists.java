package LeetCode.Easy;

public class MergeTwoLists {
//    Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the
//    nodes of the first two lists.
//
//            Example 1:
//
//
//    Input: l1 = [1,2,4], l2 = [1,3,4]
//    Output: [1,1,2,3,4,4]
//    Example 2:
//
//    Input: l1 = [], l2 = []
//    Output: []
//    Example 3:
//
//    Input: l1 = [], l2 = [0]
//    Output: [0]
//
//
//    Constraints:
//
//    The number of nodes in both lists is in the range [0, 50].
//            -100 <= Node.val <= 100
//    Both l1 and l2 are sorted in non-decreasing order.

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode headNewList = new ListNode(0);
       ListNode pointerToHead = headNewList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointerToHead.next = l1;
                l1 = l1.next;
            } else {
                pointerToHead.next = l2;
                l2 = l2.next;
            }
            pointerToHead = pointerToHead.next;
        }

        if (l1 != null) {
            pointerToHead.next = l1;
        }
        if (l2 != null) {
            pointerToHead.next = l2;
        }
        return headNewList.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode newListHEAD = new ListNode(0);
        ListNode p = newListHEAD;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1; //next no. of newListHEAD is p1(l1).
                p1 = p1.next; //making next element of p1 to current p1.
            } else {
                p.next = p2;   //next no. of newListHEAD is p2(l2).
                p2 = p2.next;   //making next element of p2 to current p2.
            }
            p = p.next;   //once value has been updated, move the head to next element(i+1)
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }
        return newListHEAD.next;
    }

//    public static void main(String[] args) {
//        ListNode llist1 = new ListNode();
//        ListNode llist2 = new ListNode();
//
//        // Node head1 = new Node(5);
//        llist1.val(new ListNode(5));
//        llist1.val(new ListNode(10));
//        llist1.val(new ListNode(15));
//
//        // Node head2 = new Node(2);
//        llist2.addToTheLast(new Node(2));
//        llist2.addToTheLast(new Node(3));
//        llist2.addToTheLast(new Node(20));
//
//
//        llist1.head = new Gfg().sortedMerge(llist1.head,
//                llist2.head);
//        llist1.printList();
//    }
}
