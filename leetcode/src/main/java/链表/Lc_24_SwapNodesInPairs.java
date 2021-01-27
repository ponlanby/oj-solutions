package 链表;

import base.ListNode;

/**
 * @author tongruochen
 * @since 2020/3/12
 */
public class Lc_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode emptyHead = pre;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = a.next;
            ListNode post = b.next;

            b.next = a;
            a.next = post;
            pre.next = b;

            pre = a;
        }
        return emptyHead.next;
    }
}
