package com.lange.exercise.algorithms;

import com.google.common.collect.Lists;
import com.lange.exercise.utils.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by lange on 24/3/16.
 */
public class LongestIncresingSubsequenceSizeAlgorithm {

    List<List<Integer>> longestSubsequences;
    final int[] input;

    private LongestIncresingSubsequenceSizeAlgorithm(final int[] input) {
        this.input = input;
    }

    public List<List<Integer>> getSequenceSize() {
        return getSequenceSize(input.length);
    }

    public List<List<Integer>> getSequenceSize(int sizeLimit) {

        longestSubsequences = Lists.newArrayList();
        longestSubsequences.add(Lists.newArrayList(input[0]));

        int n = 1;
        while (n < sizeLimit) {
            int inputToAppend = input[n];

            if (input.length > 1) {
                List<Integer> sequence = Lists.newArrayList(longestSubsequences.get(longestSubsequences.size() - 1));

                int sequenceLastIndex = sequence.size() - 1;
                if (sequence.get(sequenceLastIndex) < inputToAppend) {
                    sequence.add(inputToAppend);
                    longestSubsequences.add(sequence);
                } else {
                    int lastIndex = sequenceLastIndex;
                    while (lastIndex >= 0 && sequence.get(lastIndex) > inputToAppend) {
                        sequence.remove(lastIndex--);
                    }
                    sequence.add(inputToAppend);
                    longestSubsequences.set(sequence.size() - 1, sequence);
                }
            }

            n++;
        }

        return longestSubsequences;
    }

    public static LongestIncresingSubsequenceSizeAlgorithm createInstance(int... input) {
        return new LongestIncresingSubsequenceSizeAlgorithm(input);
    }

    public static List<Integer> solve(int[] input) {
        LongestIncresingSubsequenceSizeAlgorithm algo = LongestIncresingSubsequenceSizeAlgorithm.createInstance(input);

        IntStream.iterate(1, i -> i + 1).limit(input.length).forEach(i -> {
            List<List<Integer>> list = algo.getSequenceSize(i);
            List<Integer> lis = list.get(list.size() - 1);
            System.out.println(String.format("i = %s [%s] : size = %s : %s", i, input[i - 1], lis.size(), StringUtils.listJoiner(lis)));
        });

        List<List<Integer>> list = algo.getSequenceSize();
        List<Integer> lis = list.get(list.size() - 1);
        return lis;
    }
}
