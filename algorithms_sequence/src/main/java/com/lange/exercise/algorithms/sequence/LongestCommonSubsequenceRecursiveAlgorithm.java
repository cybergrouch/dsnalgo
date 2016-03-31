package com.lange.exercise.algorithms.sequence;

import com.lange.exercise.utils.ArrayUtils;

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

    /**
     * The recursive approach leverages on the top-down approach in solving LCS problem by breaking the problem down to
     * smaller problems.
     *
     * It does this by first considering the tail of the two inputs and comparing them. If they are
     * equal, then it should be concatenated at the end of result of the recursive call to derive the LCS of the
     * remaining elements of the two inputs minus their tail.
     *
     * If the two tail elements do not match, then it returns either of two results:
     * <ul>
     *     <li>result of the recursive call to derive the LCS from the first original input sequence and the second
     *     input sequence minus the tail</li>
     *     <li>result of the recursive call to derive the LCS from the first input sequence minus the tail and the
     *     second original input sequence.</li>
     * </ul>
     *
     * Of course, the base case for all recursive calls is when either of the input sequence is empty.
     *
     * Since the recursive call does not reduce the problem, then there's no reduction in the complexity of this
     * algorithm towards logarithmic time. This approach is still bound by O(n^2). In fact, this implementation hides a
     * great deal in implementing array manipulation for these:
     * <ul>
     *     <li>ArrayUtils::tail</li>
     *     <li>ArrayUtils::concat</li>
     * </ul>
     *
     * Both of these calls are bound by <code>O(n)</code> (or linear time) but since they are done several times in the
     * algorithm, it adds considerable overhead to the complexity of this approach as compared with the use of Stacks
     * in the Dynamic Programming approach which reduces the array manipulation calls.
     *
     * @param input1 the first input
     * @param input2 the second input
     * @return the longest common sequence for the two sequence inputs
     */
    @Override
    public int[] getLCS(final int[] input1, final int[] input2) {
        if (input1 == null || input1.length == 0 || input2 == null || input2.length == 0) {
            return new int[] {};
        }

        ArrayUtils.Tail tail1 = ArrayUtils.tail(input1);
        ArrayUtils.Tail tail2 = ArrayUtils.tail(input2);
        if (tail1.tail == tail2.tail) {
            return ArrayUtils.concat(getLCS(tail1.rest, tail2.rest), new int[] { tail1.tail });
        }

        int[] alt1 = getLCS(tail1.rest, input2);
        int[] alt2 = getLCS(input1, tail2.rest);
        int[] alternative = alt1;
        if (alt2.length > alt1.length) {
            alternative = alt2;
        }
        return alternative;
    }

}
