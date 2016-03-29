package com.lange.exercise.algorithms;

import com.lange.exercise.utils.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import static com.lange.exercise.utils.ArrayUtils.toIntArray;

/**
 * Created by lange on 24/3/16.
 */
public class LongestIncresingSubsequenceDPAlgorithm {

    static boolean isDebug = false;

    final int[] input;

    private LongestIncresingSubsequenceDPAlgorithm(final int[] input) {
        this.input = input;
    }

    /**
     * This algorithm employs Dynamic Programming to getLCS the Longest Increasing Subsequence problem. The problem is
     * stated simply: Given a list of random integers, find the longest increasing subsequence (i.e., numbers should be
     * increasing and should be within sequence but need not contiguous).
     *
     * We first build an array of stacks. Each <code>i</code>-th element in the array corresponds to the longest
     * sequence where <code>input[i]</code> is the last element of the sequence. This is done by a nested loop where the
     * external loop iterates through all the elements of <code>input</code> while the inner loop looks for the next
     * longest sequence where <code>input[k]</code> could be appended (k being the index controlled by the external
     * loop).
     *
     * After building the array of stack, the next step is to just find the stack with the most elements then converting
     * it back to an array.
     *
     * @return max sequence
     */
    public int[] getLIS() {
        int n = input.length;

        // qStack[i] represents the longest subsequence size which ends with element input[i]
        Stack[] qStack = new Stack[n];

        for (int k = 0; k < n; k++) {
            Stack stack = new Stack();
            for (int j = 0; j < k; j++) {
                if (input[k] <= input[j]) {
                    continue;
                }

                // input[k] > input[j]
                if (stack == null || qStack[j].size() > stack.size()) {
                    stack = new Stack();
                    stack.addAll(qStack[j]);
                }
            }

            if (stack == null) {
                stack = new Stack();
            }
            qStack[k] = stack;
            stack.push(input[k]);
        }

        Stack<Integer> maxStack = Arrays.asList(qStack).stream().max(Comparator.comparingInt(Stack::size)).get();
        return toIntArray(maxStack);
    }

    public static LongestIncresingSubsequenceDPAlgorithm createInstance(int... input) {
        return new LongestIncresingSubsequenceDPAlgorithm(input);
    }

    public static int[] solve(int[] input) {
        LongestIncresingSubsequenceDPAlgorithm algo = LongestIncresingSubsequenceDPAlgorithm.createInstance(input);

        int[] sequence = algo.getLIS();
        if (isDebug) {
            System.out.println(String.format("max size for sequence input is %s : [%s]", sequence.length, StringUtils.arrJoiner(sequence)));
        }
        return sequence;
    }
}
