package com.lange.exercise.algorithms;

import com.lange.exercise.utils.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

import static com.lange.exercise.utils.ArrayUtils.toIntArray;

/**
 * Created by lange on 27/3/16.
 */
public class LongestCommonSubsequenceRecursiveAlgorithm implements LongestCommonSubsequenceAlgorithm {

    public static LongestCommonSubsequenceRecursiveAlgorithm createInstance() {
        return new LongestCommonSubsequenceRecursiveAlgorithm();
    }

    private LongestCommonSubsequenceRecursiveAlgorithm() {
        super();
    }

    public int[] getLCS(final int[] seedInput1, final int[] seedInput2) {
        if (seedInput1 == null || seedInput1.length == 0 || seedInput2 == null || seedInput2.length == 0) {
            return new int[] {};
        }

        ArrayUtils.Tail tail1 = ArrayUtils.tail(seedInput1);
        ArrayUtils.Tail tail2 = ArrayUtils.tail(seedInput2);
        if (tail1.tail == tail2.tail) {
            return ArrayUtils.concat(getLCS(tail1.rest, tail2.rest), new int[] { tail1.tail });
        }

        int[] alt1 = getLCS(tail1.rest, seedInput2);
        int[] alt2 = getLCS(seedInput1, tail2.rest);
        int[] alternative = alt1;
        if (alt2.length > alt1.length) {
            alternative = alt2;
        }
        return alternative;
    }

}
