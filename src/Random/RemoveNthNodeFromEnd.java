package Random;

public class RemoveNthNodeFromEnd {

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
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
       temp.next = head;
       ListNode first = head;
       int len = 0;

       while (first != null) {
           len++;
           first = first.next;
       }
       len -= n;
       first = temp;
       while (len > 0) {
           len--;
           first = first.next;
       }
       first.next = first.next.next;
       return temp.next;
    }
}
