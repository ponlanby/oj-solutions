package 链表;

import base.ListNode;

/**
 * @author tongruochen
 * @since 2020/3/13
 */
public class Lc_25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;

        for (int i=1; cur!=null; i++) {
            if (i%k == 0) {
                pre = reverseGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    private ListNode reverseGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }

        return last;
    }
}
