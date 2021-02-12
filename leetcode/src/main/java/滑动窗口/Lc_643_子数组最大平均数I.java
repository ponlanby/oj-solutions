package 滑动窗口;

/**
 * @author: created by ponlanby
 * @date:2021/2/12
 */
public class Lc_643_子数组最大平均数I {

    public static double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }

        return 1.0 * maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
