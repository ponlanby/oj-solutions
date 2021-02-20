import main.java.base.ListNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/10
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
