package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: created by ponlanby
 * @date:2021/2/20
 */
public class Lc_697_数组的度 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> degrees = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (degrees.containsKey(nums[i])) {
                degrees.get(nums[i])[0]++;
                degrees.get(nums[i])[2] = i;
            } else {
                degrees.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxCount = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : degrees.entrySet()) {
            int[] degree = entry.getValue();
            if (maxCount < degree[0]) {
                maxCount = degree[0];
                minLen = degree[2] - degree[1] + 1;
            } else if (maxCount == degree[0]){
                if (minLen > degree[2] - degree[1] + 1) {
                    minLen = degree[2] - degree[1] + 1;
                }
            }
        }
        return minLen;
    }
}
