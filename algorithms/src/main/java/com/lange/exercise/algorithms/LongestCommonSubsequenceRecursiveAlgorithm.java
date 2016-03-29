package com.lange.exercise.algorithms;

import com.google.common.base.Predicates;
import com.lange.exercise.utils.ArrayUtils;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
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
public class LongestCommonSubsequenceRecursiveAlgorithm {

    public static LongestCommonSubsequenceRecursiveAlgorithm createInstance() {
        return new LongestCommonSubsequenceRecursiveAlgorithm();
    }

    private LongestCommonSubsequenceRecursiveAlgorithm() {
        super();
    }

    public int[] solve(final int[] input1, final int[] input2) {
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

        final Stack<Integer> stack = new Stack<>();
        final Pair<Integer, Integer> key = maximum.getKey();
        final int maxLength = maximum.getValue();

        int _maxLength = maxLength;
        int _i = key.getLeft() - 1;
        int _j = key.getRight() - 1;

        while (_i > 0 || _j > 0) {

            if (input1[_i] == input2[_j]) {
                stack.push(input1[_i]);
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

        return toIntArray(stack, false);
    }
}
