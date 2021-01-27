package 链表;

import base.ListNode;

/**
 * @author tongruochen
 * @since 2020/3/12
 */
public class Lc_142_环形链表II {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        ListNode startPoint = head;
        ListNode meetPoint = slow;
        while (startPoint != meetPoint) {
            startPoint = startPoint.next;
            meetPoint = meetPoint.next;
        }

        return startPoint;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        detectCycle(node1);
    }
}
