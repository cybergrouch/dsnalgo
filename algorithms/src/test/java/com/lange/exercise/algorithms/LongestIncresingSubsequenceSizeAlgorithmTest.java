package com.lange.exercise.algorithms;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by lange on 25/3/16.
 */
public class LongestIncresingSubsequenceSizeAlgorithmTest {

    @Test
    public void testInstantiation() {
        LongestIncresingSubsequenceSizeAlgorithm instance = LongestIncresingSubsequenceSizeAlgorithm.createInstance(1);
        assertThat(instance).isNotNull();
    }

    @Test
    public void testSolve() {
        int[] input = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        List<Integer> output = LongestIncresingSubsequenceSizeAlgorithm.solve(input);
        assertListElements(output, 0,4,6,9,11,15);
    }

    @Test
    public void testN16() {
        List<List<Integer>> sequenceSize = invokeForN(16);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 3),
                Lists.newArrayList(0, 4, 5),
                Lists.newArrayList(0, 4, 6, 7),
                Lists.newArrayList(0, 4, 6, 9, 11),
                Lists.newArrayList(0, 4, 6, 9, 11, 15));
    }

    @Test
    public void testN15() {
        List<List<Integer>> sequenceSize = invokeForN(15);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 3),
                Lists.newArrayList(0, 4, 5),
                Lists.newArrayList(0, 4, 6, 7),
                Lists.newArrayList(0, 4, 6, 9, 11));
    }

    @Test
    public void testN14() {
        List<List<Integer>> sequenceSize = invokeForN(14);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 3),
                Lists.newArrayList(0, 4, 5),
                Lists.newArrayList(0, 4, 6, 9),
                Lists.newArrayList(0, 4, 6, 9, 11));
    }

    @Test
    public void testN13() {
        List<List<Integer>> sequenceSize = invokeForN(13);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 3),
                Lists.newArrayList(0, 4, 5),
                Lists.newArrayList(0, 4, 6, 9),
                Lists.newArrayList(0, 4, 6, 9, 13));
    }

    @Test
    public void testN12() {
        List<List<Integer>> sequenceSize = invokeForN(12);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 1),
                Lists.newArrayList(0, 4, 5),
                Lists.newArrayList(0, 4, 6, 9),
                Lists.newArrayList(0, 4, 6, 9, 13));
    }

    @Test
    public void testN11() {
        List<List<Integer>> sequenceSize = invokeForN(11);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 1),
                Lists.newArrayList(0, 4, 5),
                Lists.newArrayList(0, 4, 6, 9));
    }

    @Test
    public void testN10() {
        List<List<Integer>> sequenceSize = invokeForN(10);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 1),
                Lists.newArrayList(0, 4, 6),
                Lists.newArrayList(0, 4, 6, 9));
    }

    @Test
    public void testN9() {
        List<List<Integer>> sequenceSize = invokeForN(9);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 1),
                Lists.newArrayList(0, 4, 6),
                Lists.newArrayList(0, 4, 6, 14));
    }

    @Test
    public void testN8() {
        List<List<Integer>> sequenceSize = invokeForN(8);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 2),
                Lists.newArrayList(0, 4, 6),
                Lists.newArrayList(0, 4, 6, 14));
    }

    @Test
    public void testN7() {
        List<List<Integer>> sequenceSize = invokeForN(7);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 2),
                Lists.newArrayList(0, 4, 6));
    }

    @Test
    public void testN6() {
        List<List<Integer>> sequenceSize = invokeForN(6);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 2),
                Lists.newArrayList(0, 4, 10));
    }

    @Test
    public void testN5() {
        List<List<Integer>> sequenceSize = invokeForN(5);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 2),
                Lists.newArrayList(0, 4, 12));
    }

    @Test
    public void testN4() {
        List<List<Integer>> sequenceSize = invokeForN(4);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 4),
                Lists.newArrayList(0, 4, 12));
    }

    @Test
    public void testN3() {
        List<List<Integer>> sequenceSize = invokeForN(3);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 4));
    }

    @Test
    public void testN2() {
        List<List<Integer>> sequenceSize = invokeForN(2);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0),
                Lists.newArrayList(0, 8));
    }

    @Test
    public void testN1() {
        List<List<Integer>> sequenceSize = invokeForN(1);

        assertListOfListElements(sequenceSize,
                Lists.newArrayList(0));
    }

    public void assertListElements(List<Integer> actual, Integer... expected) {
        assertThat(actual).containsExactly(expected);
    }

    public void assertListOfListElements(List<List<Integer>> actual, List<Integer>... expected) {
        assertThat(actual).hasSameSizeAs(expected);
        IntStream.iterate(0, i -> i + 1).limit(actual.size()).forEach(i -> {
            assertThat(actual.get(i)).hasSameSizeAs(expected[i]);
            assertThat(actual.get(i)).describedAs("Did not match::List # %s", i).containsExactly(expected[i].toArray(new Integer[expected[i].size()]));
        });
    }

    public List<List<Integer>> invokeForN(int n) {
        int[] input = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        LongestIncresingSubsequenceSizeAlgorithm instance = LongestIncresingSubsequenceSizeAlgorithm.createInstance(input);
        List<List<Integer>> sequenceSize = instance.getSequenceSize(n);
        return sequenceSize;
    }
}
