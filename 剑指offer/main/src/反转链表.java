import base.ListNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/10
 */
public class 反转链表 {

    public static ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        return cur;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reverseList(n1);
    }
}
