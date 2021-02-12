package 数组;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: created by ponlanby
 * @date:2021/1/23
 */
public class Lc989_数组形式的整数加法 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        List<Integer> result = new LinkedList<>();
        int carry = 0;
        int n = len - 1;
        while ( n >= 0 || K > 0) {
            int currA = n >= 0 ? A[n] : 0;
            int currB = K % 10;
            int sum = currA + currB + carry;
            result.add(0, sum % 10);
            carry = sum / 10;
            n--;
            K = K / 10;
        }
        if (carry != 0) {
            result.add(0, carry);
        }

        return result;
    }
}
