package com.lange.exercise.algorithms;

import com.lange.exercise.utils.StringUtils;

import java.util.Arrays;

/**
 * Created by lange on 29/3/16.
 */
public class LongestIncresingSubsequenceViaLCSAlgorithm implements LongestIncresingSubsequenceAlgorithm {

    static boolean isDebug = false;

    private LongestIncresingSubsequenceViaLCSAlgorithm() {
        super();
    }

    public static LongestIncresingSubsequenceViaLCSAlgorithm createInstance() {
        return new LongestIncresingSubsequenceViaLCSAlgorithm();
    }

    public static int[] solve(int[] input) {
        LongestIncresingSubsequenceViaLCSAlgorithm algo = LongestIncresingSubsequenceViaLCSAlgorithm.createInstance();

        int[] sequence = algo.getLIS(input);
        if (isDebug) {
            System.out.println(String.format("max size for sequence input is %s : [%s]", sequence.length, StringUtils.arrJoiner(sequence)));
        }
        return sequence;
    }

    /**
     * The insight is that since the output should be increasing then it is a subsequence of the sorted sequence of the
     * input as well as a subsequence of the original input (the original ordering). Based on this, we can derive a
     * sequence which is the Longest Increasing Subsequence of the input sequence by solving for the Longest Common
     * Subsequence of the sorted input sequence and the original input sequence.
     *
     * @param input1 the original sequence
     * @return the longest increasing subsequence based from the input sequence
     */
    @Override
    public int[] getLIS(int[] input1) {
        int[] input2 = Arrays.copyOf(input1, input1.length);
        Arrays.sort(input2);
        LongestCommonSubsequenceDPAlgorithm lcsAlgorithm = LongestCommonSubsequenceDPAlgorithm.createInstance();
        return lcsAlgorithm.getLCS(input1, input2);
    }
}
