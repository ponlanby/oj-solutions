package 滑动窗口;

import java.util.TreeMap;

/**
 * @author: created by ponlanby
 * @date:2021/2/21
 */
public class Lc_1438_绝对差不超过限制的最长连续子数组 {

    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        System.out.println(longestSubarray(nums, 4));
    }
}
