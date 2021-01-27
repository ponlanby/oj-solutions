package 链表;

import base.ListNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/10
 */
public class Lc_0208_环路检测 {

    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 第一次相遇
        while (slow != null && fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        // 遍历到结尾不存在环路
        if (fast == null || slow == null) {
            return null;
        }

        // 头结点出发，相遇节点就是环路入口
        ListNode entrance = head;
        while (entrance != slow &&entrance!=null &&slow!=null) {
            entrance = entrance.next;
            slow = slow.next;
        }
        return entrance;
    }
}
