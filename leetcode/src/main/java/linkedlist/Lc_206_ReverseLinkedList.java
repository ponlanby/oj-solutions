package linkedlist;

import base.ListNode;

/**
 * @author tongruochen
 * @since 2020/3/12
 */
public class Lc_206_ReverseLinkedList {

    public ListNode buildLinkedList(int[] array) {
        ListNode head, p;
        head = p = new ListNode(array[0]);
        for (int i=1; i<array.length-1; i++) {
            ListNode node = new ListNode(array[i]);
            p.next = node;
            p = node;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        return head;
    }
}
