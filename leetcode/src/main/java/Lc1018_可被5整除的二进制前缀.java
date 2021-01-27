import java.util.ArrayList;
import java.util.List;

/**
 * @author: created by ponlanby
 * @date:2021/1/14
 */
public class Lc1018_可被5整除的二进制前缀 {

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList();
        int lastDigit = 0;
        for (int i : A) {
            lastDigit = (lastDigit * 2 + i) % 10;
            result.add(lastDigit % 5 == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A ={0,1,1,1,1,1};
        prefixesDivBy5(A);
    }
}
