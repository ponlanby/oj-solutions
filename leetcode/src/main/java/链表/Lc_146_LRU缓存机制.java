package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: created by ponlanby
 * @date:2021/1/23
 */
public class Lc_146_LRU缓存机制 {

    public static class LRUCache {
        private Map<Integer, DLinkedNode> CACHE = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.setNext(tail);
            tail.setPre(head);
        }

        public int get(int key) {
            DLinkedNode node = CACHE.get(key);
            if (null == node) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.getValue();
        }

        public void put(int key, int value) {
            DLinkedNode node = CACHE.get(key);
            if (null == node) {
                // 如果不存在则插入
                node = new DLinkedNode(key, value);
                CACHE.put(key, node);
                addToHead(node);
                ++size;
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    CACHE.remove(tail.getKey());
                    --size;
                }
            } else {
                // 如果存在则移到头部
                node.setValue(value);
                this.moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.setPre(head);
            node.setNext(head.getNext());
            head.getNext().setPre(node);
            head.setNext(node);
        }

        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.getPre();
            DLinkedNode post = node.getNext();
            pre.setNext(post);
            post.setPre(pre);
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode last = tail.getPre();
            removeNode(last);
            return last;
        }

        private class DLinkedNode {
            private int key;
            private int value;
            private DLinkedNode pre;
            private DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public DLinkedNode getPre() {
                return pre;
            }

            public void setPre(DLinkedNode pre) {
                this.pre = pre;
            }

            public DLinkedNode getNext() {
                return next;
            }

            public void setNext(DLinkedNode next) {
                this.next = next;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
