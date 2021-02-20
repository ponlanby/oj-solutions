package 堆;

import java.util.*;

/**
 * @author tongruochen
 * @since 2020/3/25
 */
public class Lc_692_TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        Queue<String> heap = new PriorityQueue<>(
                (w1, w2)->wordCount.get(w1).equals(wordCount.get(w2))
                        ? w2.compareTo(w1)
                        : wordCount.get(w1) - wordCount.get(w2));

        for (String word : wordCount.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> minToMaxList = new ArrayList<>();
        while (!heap.isEmpty()) {
            minToMaxList.add(heap.poll());
        }

        Collections.reverse(minToMaxList);
        return minToMaxList;
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        topKFrequent(words, 4);
    }
}
