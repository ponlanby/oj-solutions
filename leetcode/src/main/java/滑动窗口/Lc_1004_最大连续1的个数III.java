package 滑动窗口;

/**
 * @author: created by ponlanby
 * @date:2021/2/19
 */
public class Lc_1004_最大连续1的个数III {

    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rsum = rsum + 1 - A[right];
            while (lsum < rsum - K) {
                lsum = lsum + 1 - A[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
