package 数组;

/**
 * @author: created by ponlanby
 * @date:2021/2/17
 */
public class Lc_566_重塑矩阵 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = nums[i / n][i % n];
        }

        return result;
    }
}
