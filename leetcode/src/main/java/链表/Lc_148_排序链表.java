package 链表;

import base.ListNode;

/**
 * @author: created by ponlanby
 * @date:2021/1/24
 */
public class Lc_148_排序链表 {

    // 自底向上归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        // 1. 首先从头向后遍历,统计链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        // 2. 初始化 引入dummynode
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 3. 每次将链表拆分成若干个长度为subLen的子链表 , 并按照每两个子链表一组进行合并
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead;
            // curr用于记录拆分链表的位置
            ListNode curr = dummyHead.next;

            // 如果链表没有被拆完
            while (curr != null) {
                // 3.1 拆分subLen长度的链表1
                // 第一个链表的头 即 curr初始的位置
                ListNode head1 = curr;
                // 拆分出长度为subLen的链表1
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                // 3.2 拆分subLen长度的链表2
                // 第二个链表的头  即 链表1尾部的下一个位置
                ListNode head2 = curr.next;
                // 断开第一个链表和第二个链表的链接
                curr.next = null;
                // 第二个链表头 重新赋值给curr
                curr = head2;
                // 再拆分出长度为subLen的链表2
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }

                // 3.3 再次断开 第二个链表最后的next的链接
                ListNode next = null;
                if (curr != null) {
                    // next用于记录 拆分完两个链表的结束位置
                    next = curr.next;
                    // 断开连接
                    curr.next = null;
                }

                // 3.4 合并两个subLen长度的有序链表
                ListNode merged = mergeTwoLists(head1, head2);
                // prev.next 指向排好序链表的头
                prev.next = merged;
                // while循环 将prev移动到 subLen*2 的位置后去
                while (prev.next != null) {
                    prev = prev.next;
                }
                // next用于记录 拆分完两个链表的结束位置
                curr = next;
            }
        }

        // 返回新排好序的链表
        return dummyHead.next;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pivot = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pivot.next = l1;
                l1 = l1.next;
            } else {
                pivot.next = l2;
                l2 = l2.next;
            }
            pivot = pivot.next;
        }
        if (l1 != null) {
            pivot.next = l1;
        }
        if (l2 != null) {
            pivot.next = l2;
        }

        return dummyHead.next;
    }
}
