package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tongruochen
 * @since 2020/3/15
 */
public class Lc_15_3Sum {

    // a+b+c = 0
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            // 跳过重复的 a
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int complement = 0 - nums[i];
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                if (complement == nums[begin] + nums[end]) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[begin]);
                    triplet.add(nums[end]);
                    result.add(triplet);

                    // 跳过重复的 b
                    while (begin < end && nums[begin] == nums[begin+1]) {
                        begin++;
                    }
                    // 跳过重复的 c
                    while (begin < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                    begin++;
                    end--;
                } else if (complement > nums[begin] + nums[end]) {
                    begin++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        threeSum(nums);
    }
}
