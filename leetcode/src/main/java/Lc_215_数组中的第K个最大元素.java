import java.util.PriorityQueue;

/**
 * @author: created by ponlanby
 * @date:2021/1/27
 */
public class Lc_215_数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        int length = nums.length;
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > length) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
