package 数组;

import java.util.Arrays;

/**
 * @author: created by ponlanby
 * @date:2021/1/28
 */
public class Lc_724_寻找数组的中心索引 {

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i< nums.length; i++) {
            if (total == 2 * leftSum + nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
