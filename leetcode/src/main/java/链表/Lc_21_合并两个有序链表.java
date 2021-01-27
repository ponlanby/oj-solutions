package 链表;

import base.ListNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/22
 */
public class Lc_21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

        ListNode pivot = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pivot.next = l1;
                l1 = l1.next;
            } else {
                pivot.next = l2;
                l2 = l2.next;
            }
            pivot = pivot.next;
        }

        pivot.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
