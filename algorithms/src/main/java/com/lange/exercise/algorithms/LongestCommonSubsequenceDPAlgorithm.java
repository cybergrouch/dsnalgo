package com.lange.exercise.algorithms;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by lange on 27/3/16.
 */
public class LongestCommonSubsequenceDPAlgorithm implements LongestCommonSubsequenceAlgorithm {

    public static LongestCommonSubsequenceDPAlgorithm createInstance() {
        return new LongestCommonSubsequenceDPAlgorithm();
    }

    private LongestCommonSubsequenceDPAlgorithm() {
        super();
    }

    /**
     * The Dynamic Programming approach has two steps: first, make an initial pass to determine the path where the two
     * structures correspond and calculate the length associated with that, and second, to reconstruct the list based on
     * this initial pass.
     *
     * For the initial pass, the insight is that the correspondence of elements between the two inputs builds on a
     * previous correspondence (or nothing if what's being considered are the first corresponding elements). Thus, we
     * can associate a number to this correspondence of elements--the length of the "virtual" sequence which is the
     * common subsequence between the two. This length is built by incrementing the number associated to the previous
     * correspondence.
     *
     * New equally important in the initial pass is to associate a number of non-corresponding elements. This is to
     * guide the second part of the approach in reconstructing the list. The number is just basically the maximum
     * between the number associated with the previous element of the first sequence against the current element of the
     * second sequence and the number associated with the current element of the first sequence against the previous
     * element of the second sequence. Naturally, the bigger number will correspond to the longer length connecting to
     * a corresponding elements between these two sequences.
     *
     * Thus basically, we're drawing the path of this "virtual" or "unmaterialised" subsequence through their lengths.
     * The job of the second phase is to reconstruct the longest common sequence from this map of path. We employ three things:
     * <ol>
     *     <li>a collection object to keep hold of the sequence as we trace through the map</li>
     *     <li>an index for the first sequence</li>
     *     <li>an index for the second sequence</li>
     * </ol>
     *
     * We'll now loop through the indices starting from the map element with the longest length with corresponding
     * indices first. We check on each loop if the elements correspond to each other between the two input sequences
     * (and on the initial pass, this is the case). If they do, we store that element in the collection object. Then we
     * decrement both indices. If they don't correspond, we need to choose whether to decrement which index to decrement
     * (the index for the first sequence or the second sequence). To help us decide which one to decrement, we again
     * will consult the map we assembled on the first pass. We are looking for the route which is longer so we decide
     * which index to increment based on the which element in the map is longer: the element in the map associated with
     * the decremented first sequence index or the decremented second sequence index). Whichever is longer, means it
     * traces back to the longer corresponding element. Then we decrement the appropriate index of choice and loop
     * again.
     *
     * The loop ends when either of the indices acquires a value less than 0. Then we just return the collection as a
     * sequence as our result.
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

        final int n = input1.length;
        final int m = input2.length;

        final Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        IntStream.range(0, n+1).forEach(i -> {
            IntStream.range(0, m+1).forEach(j -> {
                if (i == 0 || j == 0) {
                    map.put(Pair.of(i, j), 0);
                    return;
                }

                if (input1[i - 1] == input2[j - 1]) {
                    int beforeValue = map.getOrDefault(Pair.of(i - 1, j - 1), 0);
                    int afterValue = beforeValue + 1;
                    map.put(Pair.of(i, j), map.getOrDefault(Pair.of(i - 1, j - 1), 0) + 1);
                    return;
                } else {
                    int beforeValue1 = map.getOrDefault(Pair.of(i - 1, j), 0);
                    int beforeValue2 = map.getOrDefault(Pair.of(i, j - 1), 0);
                    int afterValue = Math.max(beforeValue1, beforeValue2);
                    map.put(Pair.of(i, j), Math.max(map.getOrDefault(Pair.of(i - 1, j), 0), map.getOrDefault(Pair.of(i, j - 1), 0)));
                    return;
                }
            });
        });

        final Map.Entry<Pair<Integer, Integer>, Integer> maximum = map.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getLeft() > 0)
                .filter(entry -> entry.getKey().getRight() > 0)
                .filter(entry -> input1[entry.getKey().getLeft() - 1] == input2[entry.getKey().getRight() - 1])
                .max(Comparator.comparing(entry -> entry.getValue())).get();

        final int[] sequence = new int[maximum.getValue()];
        final Pair<Integer, Integer> key = maximum.getKey();

        int _i = key.getLeft() - 1;
        int _j = key.getRight() - 1;

        int k = sequence.length - 1;
        while (_i >= 0 && _j >= 0) {

            if (input1[_i] == input2[_j]) {
                sequence[k--] = input1[_i];
                _i--;
                _j--;
            } else {
                if (map.getOrDefault(Pair.of(_i, _j + 1), 0) < map.getOrDefault(Pair.of(_i + 1, _j), 0)) {
                    _j--;
                } else {
                    _i--;
                }
            }
        }

        return sequence;
    }

}
