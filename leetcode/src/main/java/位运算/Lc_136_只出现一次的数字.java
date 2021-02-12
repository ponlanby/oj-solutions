package 位运算;

/**
 * @author: created by ponlanby
 * @date:2021/1/30
 */
public class Lc_136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
