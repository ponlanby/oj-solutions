package 剪枝;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tongruochen
 * @since 2020/3/28
 */
public class Lc_22_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    private static void generate(int leftCount, int rightCount, int n, String parenthesis, List<String> result) {
        if (leftCount == n && rightCount == n) {
            result.add(parenthesis);
        }
        if (leftCount < n) {
            generate(leftCount+1, rightCount, n, parenthesis + "(", result);
        }
        if (rightCount < n && rightCount < leftCount) {
            generate(leftCount, rightCount+1, n, parenthesis + ")", result);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
