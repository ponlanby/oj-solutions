package 位运算;

/**
 * @author: created by ponlanby
 * @date:2021/1/30
 */
public class Lc_461_汉明距离 {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                distance++;
            }
            xor = xor >> 1;
        }
        return distance;
    }
}
