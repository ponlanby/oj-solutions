package 动态规划;

/**
 * @author: created by ponlanby
 * @date:2021/1/26
 */
public class Lc_152_乘积最大子数组 {

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(max[i - 1] * nums[i], nums[i]));
        }

        int maxProduct = max[0];
        for (int m : max) {
            if (m > maxProduct) {
                maxProduct = m;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-2,-9,-6};
        System.out.println(maxProduct(arr));
    }
}
