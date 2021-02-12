package 滑动窗口;

import java.util.Arrays;

/**
 * @author: created by ponlanby
 * @date:2021/2/6
 */
public class Lc_1423_可获得的最大点数 {

    /**
     * 因为最后剩下的必然是连续的 n-k 张卡牌
     * 所以只需求 n-k 张卡牌的最小值
     */
    public static int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int windowSize = length - k;
        int sum = 0;
        // 取前 n-k 个作为初始值
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }

        int minSum = sum;
        for (int i = windowSize; i < length; i++) {
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }

        return Arrays.stream(cardPoints).sum() - minSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {11,49,100,20,86,29,72};
        System.out.println(maxScore(cardPoints, 4));
    }
}