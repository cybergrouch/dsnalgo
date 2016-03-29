package com.lange.exercise.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by lange on 27/3/16.
 */
public class ArrayUtilsTest {

    @Test
    public void testTail() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        ArrayUtils.Tail output = ArrayUtils.tail(input);
        assertThat(output).isNotNull();
        TestUtils.assertListElements(output.rest, 1, 2, 3, 4);
        assertEquals(output.tail, 5);
    }

    @Test
    public void testHead() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        ArrayUtils.Head output = ArrayUtils.head(input);
        assertThat(output).isNotNull();
        TestUtils.assertListElements(output.rest, 2, 3, 4, 5);
        assertEquals(output.head, 1);
    }

    @Test
    public void testToIntArray() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int[] intArray = ArrayUtils.toIntArray(stack);
        TestUtils.assertListElements(intArray, 1, 2, 3, 4);
    }
}
