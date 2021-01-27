package 分治;

/**
 * @author tongruochen
 * @since 2020/3/16
 */
public class Lc_50_Pow {

    public static double myPow(double x, int n) {
        long l = n;
        if (l < 0) {
            x = 1 / x;
            l *= -1;
        }
        double pow = 1;
        while (l != 0) {
            if ((l&1) != 0) {
                pow *= x;
            }
            x *= x;
            l >>= 1;
        }
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
