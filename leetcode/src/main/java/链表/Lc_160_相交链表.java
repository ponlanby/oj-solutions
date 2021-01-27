package 链表;

import base.ListNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/26
 */
public class Lc_160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pivotA = headA;
        ListNode pivotB = headB;
        while (pivotA != pivotB) {
            pivotA = pivotA == null ? headB : pivotA.next;
            pivotB = pivotB == null ? headA : pivotB.next;
        }
        return pivotA;
    }
}
