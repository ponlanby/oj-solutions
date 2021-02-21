package 滑动窗口;

/**
 * @author: created by ponlanby
 * @date:2021/2/19
 */
public class Lc_1004_最大连续1的个数III {

    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < n) {
            if (A[right] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if (A[left++]  == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
