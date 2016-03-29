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

    @Override
    public int[] getLIS(int[] input1) {
        int[] input2 = Arrays.copyOf(input1, input1.length);
        Arrays.sort(input2);
        LongestCommonSubsequenceDPAlgorithm lcsAlgorithm = LongestCommonSubsequenceDPAlgorithm.createInstance();
        return lcsAlgorithm.getLCS(input1, input2);
    }
}
