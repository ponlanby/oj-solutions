package 贪心;

/**
 * @author: created by ponlanby
 * @date:2021/2/15
 */
public class Lc_485_最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, currentCount);
                currentCount = 0;
            }
        }
        maxConsecutive = Math.max(maxConsecutive, currentCount);
        return maxConsecutive;
    }
}
