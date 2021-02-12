import java.util.ArrayList;
import java.util.List;

/**
 * @author: created by ponlanby
 * @date:2021/2/12
 */
public class Lc_119_杨辉三角II {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long)row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
