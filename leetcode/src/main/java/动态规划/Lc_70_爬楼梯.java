package 动态规划;

/**
 * @author: created by ponlanby
 * @date:2021/1/31
 */
public class Lc_70_爬楼梯 {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
