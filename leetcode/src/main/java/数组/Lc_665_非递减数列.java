package 数组;

/**
 * @author: created by ponlanby
 * @date:2021/2/13
 */
public class Lc_665_非递减数列 {

    public boolean checkPossibility1(int[] nums) {
        /**
         * 至多一个 i 满足 nums[i] > nums[i+1]
         */
        for (int i = 0; i < nums.length - 1; i++) {
            // 如果找到 nums[i] > nums[i+1] 则交换
            if (nums[i] > nums[i + 1]) {
                int x = nums[i], y = nums[i + 1];
                if (x > y) {
                    nums[i] = y;
                    // nums[i]改成nums[i+1]后仍然非递减
                    if (isSorted(nums)) {
                        return true;
                    }

                    nums[i] = x; // 复原
                    // nums[i+1]改成nums[i]后仍然非递减
                    nums[i + 1] = x;
                    return isSorted(nums);
                }
            }
        }
        return true;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPossibility2(int[] nums) {
        // 不满足非递减的i的个数
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }

                /**
                 *
                 */
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }
}
