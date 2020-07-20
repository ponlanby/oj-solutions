package heap;

import java.util.PriorityQueue;

/**
 * @author tongruochen
 * @since 2020/3/14
 */
public class Lc_703_KthLargestElementInAStream {

    public static class KthLargest {
        PriorityQueue<Integer> queue;
        int size;

        public KthLargest(int k, int[] nums){
            queue = new PriorityQueue<Integer>();
            this.size = k;
            for (int i : nums) {
                queue.add(i);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        public int add (int val){
            queue.add(val);
            if (queue.size() > size) {
                queue.poll();
            }
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,8,2};

        KthLargest heap = new KthLargest(3, arr);
        heap.add(3);
        heap.add(5);
        heap.add(10);
    }
}
