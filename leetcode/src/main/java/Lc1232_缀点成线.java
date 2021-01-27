/**
 * @author: created by ponlanby
 * @date:2021/1/17
 */
public class Lc1232_缀点成线 {

    public boolean checkStraightLine(int[][] coordinates) {
        // 斜率相等
        int length = coordinates.length;

        // (y2 - y1)(x3 - x2) == (y3 - y3)(x2 - x1)
        for (int i = 1; i < length - 1; i++) {
            if ((coordinates[i][1] - coordinates[i-1][1]) * (coordinates[i+1][0] - coordinates[i][0]) != (coordinates[i+1][1] - coordinates[i][1]) * (coordinates[i][0] - coordinates[i-1][0])) {
                return false;
            }
        }
        return true;
    }
}
