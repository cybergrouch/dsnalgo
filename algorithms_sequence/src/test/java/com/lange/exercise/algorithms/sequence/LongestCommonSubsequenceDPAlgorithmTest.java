package com.lange.exercise.algorithms.sequence;

import com.lange.exercise.algorithms.sequence.LongestCommonSubsequenceDPAlgorithm;
import org.junit.Test;

import static com.lange.exercise.utils.TestUtils.assertListElements;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by lange on 25/3/16.
 */
public class LongestCommonSubsequenceDPAlgorithmTest {

    @Test
    public void testInstantiation() {
        LongestCommonSubsequenceDPAlgorithm instance = LongestCommonSubsequenceDPAlgorithm.createInstance();
        assertThat(instance).isNotNull();
    }

    @Test
    public void testSolve1() {
        int[] input1 = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1,   9, 5, 13, 3, 11, 7, 15 };
        int[] input2 = new int[] { 8, 3, 2, 1,  6, 14, 12, 7, 20, 19, 5, 13, 57 };
        LongestCommonSubsequenceDPAlgorithm instance = LongestCommonSubsequenceDPAlgorithm.createInstance();

        int[] output = instance.getLCS(input1, input2);
        assertListElements(output, 8, 2, 6, 14, 5, 13);
    }

    @Test
    public void testSolve2() {
        int[] input1 = new int[] { 1, 2, 3, 2 };
        int[] input2 = new int[] { 2, 4, 3, 1, 2 };
        LongestCommonSubsequenceDPAlgorithm instance = LongestCommonSubsequenceDPAlgorithm.createInstance();

        int[] output = instance.getLCS(input1, input2);
        assertListElements(output, 2, 3, 2);
    }


    @Test
    public void testSolve3() {
        int[] input1 = new int[] { 1, 2, 3, 2, 10, 9, 8 };
        int[] input2 = new int[] { 2, 4, 3, 1, 2, 4, 10, 9, 8 };
        LongestCommonSubsequenceDPAlgorithm instance = LongestCommonSubsequenceDPAlgorithm.createInstance();

        int[] output = instance.getLCS(input1, input2);
        assertListElements(output, 2, 3, 2, 10, 9, 8);
    }

    @Test
    public void testSolve4() {
        int[] input1 = new int[] { 0, 1, 2, 3 };
        int[] input2 = new int[] { 0, 2, 4, 3 };
        LongestCommonSubsequenceDPAlgorithm instance = LongestCommonSubsequenceDPAlgorithm.createInstance();

        int[] output = instance.getLCS(input1, input2);
        assertListElements(output, 0, 2, 3);
    }

}
