import java.util.ArrayList;
import java.util.List;

/**
 * @author: created by ponlanby
 * @date:2021/1/10
 */
public class Lc228_汇总区间 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        for (int j=0; j < nums.length; j++) {
            // 遍历到倒数第二个节点或下一个节点非顺序递增，则本次遍历结束
            if (j + 1 == nums.length || nums[j] + 1 != nums[j + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                result.add(sb.toString());
                i = j+1;
            }
        }

        return result;
    }
}
