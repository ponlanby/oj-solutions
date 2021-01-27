import java.util.LinkedList;

/**
 * @author: created by ponlanby
 * @date:2021/1/17
 */
public class Lc239_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length < k || k < 1) {
            return null;
        }

        // first存最大值的下标，并且在超出窗口时被弹出（后面的值都比他小），last弹出比新进来的值小的key
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            // 弹出所有比nums[i]小的
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);

            // 队头（下标）已经在窗口外
            if (queue.peekFirst() <= (i - k)) {
                queue.pollFirst();
            }
            // 窗口形成了
            if (i >= k - 1) {
                result[index++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}
