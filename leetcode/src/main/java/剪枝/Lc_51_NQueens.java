package 剪枝;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tongruochen
 * @since 2020/3/28
 */
public class Lc_51_NQueens {

    public static List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        dfs(0, n, result, new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());

        return generateResult(result, n);
    }

    private static void dfs(int row, int n, List<List<Integer>> result, List<Integer> colPositions, Set<Integer> cols, Set<Integer> pie, Set<Integer> na) {
        if (row >= n) {
            result.add(new ArrayList<>(colPositions));
            return;
        }

        for (int col=0; col<n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }

            cols.add(col);
            pie.add(row + col);
            na.add(row - col);

            colPositions.add(col);
            dfs(row + 1, n, result, colPositions, cols, pie, na);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            colPositions.remove(colPositions.size() - 1);
        }
    }

    private static List<List<String>> generateResult(List<List<Integer>> result, int n) {
        List<List<String>> output = new ArrayList<>();
        for (List<Integer> solution : result) {
            List<String> solutionOutput = new ArrayList<>();
            for (Integer col : solution) {
                int front = col - 1;
                int back = n - col - 1;
                StringBuilder sb = new StringBuilder();
                while (front-- >= 0) {
                    sb.append(".");
                }
                sb.append("Q");
                while (back-- > 0) {
                    sb.append(".");
                }
                solutionOutput.add(sb.toString());
            }
            output.add(solutionOutput);
        }
        return output;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
