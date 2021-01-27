package 链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tongruochen
 * @since 2020/3/14
 */
public class Lc_239_SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> maxList = new ArrayList<Integer>();

        // store the index
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i=0; i<nums.length; i++) {
            // 如果队尾对应的元素小于新元素，则弹出队尾并加入新元素，否则直接加入新元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            // 弹出过期数据
            if (i-k >= deque.peekFirst()) {
                deque.pollFirst();
            }

            // 保存当前最大值
            if (i-k+1 >= 0) {
                maxList.add(nums[deque.peekFirst()]);
            }
        }

        return maxList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};

        maxSlidingWindow(arr, 3);
    }
}
