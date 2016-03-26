package com.lange.exercise.algorithms;

import com.google.common.collect.Lists;
import com.lange.exercise.utils.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by lange on 24/3/16.
 */
public class LongestIncresingSubsequenceSizeDPAlgorithm {

    static boolean isDebug = false;

    final int[] input;

    private LongestIncresingSubsequenceSizeDPAlgorithm(final int[] input) {
        this.input = input;
    }

    public List<List<Integer>> getSequenceSize() {
        return getSequenceSize(input.length);
    }

    /**
     * This algorithm employs Dynamic Programming to solve the Longest Increasing Subsequence problem. The problem is
     * stated simply: Given a list of random integers, find the longest increasing subsequence (i.e., numbers should be
     * increasing and should be within sequence but need not contiguous).
     *
     * For this Dynamic Programming approach, we build the list from the ground up by considering the input array
     * elements sequentially one-by-one. Along the way, we try to construct a map where the values are subsequences of
     * the original input mapped against its size.
     *
     * So there is an external loop that controls the iteration for building smaller subsequence to bigger subsequence.
     * There's also an internal loop which iterates through the elements of the input list.
     *
     * The base case is for L(1) (list of size 1) and for simplicity we just take the first element of the input.
     *
     * For the second external loop, we try to derive L(2) from L(1) by considering the second element. If the second element is
     * greater that L(1)'s last element, then we can easily append it to L(1) to derive L(2) which has just one more
     * than the side of L(1) (or 2 to be precise). If the second element is lesser than L(1)'s last element, we derive a
     * new L(1) replacing the last value with that of the second element.
     *
     * For the next elements, we just apply the same principle by trying to build on top of the previous sequence--i.e.,
     * we are trying to derive L(n+1) from L(n). Again we apply 3 derivation flows:
     * <ol>
     *     <li>If the second element > last element of L(n), then L(n+1) = L(n) + second element</li>
     *     <li>If the second elemnt < last element of L(n), then new L(n) = L(n) - last element + second element</li>
     *     <li>If the seocnd element == last element of L(n), then we cannot derive L(n+1) from L(n)</li>
     * </ol>
     *
     * @param sizeLimit
     * @return
     */
    public List<List<Integer>> getSequenceSize(int sizeLimit) {

        List<List<Integer>> longestSubsequences = Lists.newArrayList();
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

    public static LongestIncresingSubsequenceSizeDPAlgorithm createInstance(int... input) {
        return new LongestIncresingSubsequenceSizeDPAlgorithm(input);
    }

    public static List<Integer> solve(int[] input) {
        LongestIncresingSubsequenceSizeDPAlgorithm algo = LongestIncresingSubsequenceSizeDPAlgorithm.createInstance(input);

        IntStream.iterate(1, i -> i + 1).limit(input.length).forEach(i -> {
            List<List<Integer>> list = algo.getSequenceSize(i);
            List<Integer> lis = list.get(list.size() - 1);
            if (isDebug) {
                System.out.println(String.format("i = %s [%s] : size = %s : %s", i, input[i - 1], lis.size(), StringUtils.listJoiner(lis)));
            }
        });

        List<List<Integer>> list = algo.getSequenceSize();
        List<Integer> lis = list.get(list.size() - 1);
        return lis;
    }
}
