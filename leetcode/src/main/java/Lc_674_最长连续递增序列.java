/**
 * @author: created by ponlanby
 * @date:2021/1/24
 */
public class Lc_674_最长连续递增序列 {

    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int start = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
