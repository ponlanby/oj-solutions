package 数组;

import java.util.Arrays;

/**
 * @author: created by ponlanby
 * @date:2021/2/16
 */
public class Lc_561_数组拆分I {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int minSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            minSum += nums[i];
        }
        return minSum;
    }
}
