package 数组.差分数组;

/**
 * @author: created by ponlanby
 * @date:2021/2/18
 */
public class Lc_995_K连续位的最小翻转次数 {

    public static int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] diff = new int[n + 1];
        int result = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            revCnt += diff[i];
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1;
                }
                ++result;
                ++revCnt;
                --diff[i + K];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {0, 1, 0};
        int[] A2 = {1, 1, 0};
        int[] A3 = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(minKBitFlips(A3, 3));
    }
}
