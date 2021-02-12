package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: created by ponlanby
 * @date:2021/2/12
 */
public class Lc_888_公平的糖果交换 {

    /**
     * sumA - x + y = sumB - y + x
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
