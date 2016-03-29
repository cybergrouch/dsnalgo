package com.lange.exercise.algorithms;

import org.junit.Test;

import static com.lange.exercise.utils.TestUtils.assertListElements;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by lange on 25/3/16.
 */
public class LongestIncresingSubsequenceViaLCSAlgorithmTest {

    @Test
    public void testInstantiation() {
        LongestIncresingSubsequenceViaLCSAlgorithm instance = LongestIncresingSubsequenceViaLCSAlgorithm.createInstance();
        assertThat(instance).isNotNull();
    }

    @Test
    public void testSolve() {
        int[] input = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        int[] output = LongestIncresingSubsequenceViaLCSAlgorithm.solve(input);
        assertListElements(output, 0, 4, 6, 9, 13, 15);
    }

}
