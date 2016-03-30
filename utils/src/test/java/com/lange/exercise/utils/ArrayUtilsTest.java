package com.lange.exercise.utils;

import org.junit.Test;

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
    public void testTail2() {
        int[] input = new int[] { 1, 2 };
        ArrayUtils.Tail output = ArrayUtils.tail(input);
        assertThat(output).isNotNull();
        TestUtils.assertListElements(output.rest, 1);
        assertEquals(output.tail, 2);
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
    public void testHead2() {
        int[] input = new int[] { 1, 2 };
        ArrayUtils.Head output = ArrayUtils.head(input);
        assertThat(output).isNotNull();
        TestUtils.assertListElements(output.rest, 2);
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

    @Test
    public void testReverse() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        int[] intArray = ArrayUtils.reverse(input);
        TestUtils.assertListElements(intArray, 5, 4, 3, 2, 1);
    }

    @Test
    public void testToStack() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        Stack<Integer> stack = ArrayUtils.toStack(input);
        int[] intArray = ArrayUtils.toIntArray(stack);
        TestUtils.assertListElements(intArray, 1, 2, 3, 4, 5);
    }

    @Test
    public void testAppendToStack() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        ArrayUtils.appendToStack(stack, input);
        int[] intArray = ArrayUtils.toIntArray(stack);
        TestUtils.assertListElements(intArray, 10, 20, 30, 40, 1, 2, 3, 4, 5);
    }

    @Test
    public void testConcat() {
        int[] input1 = new int[] { 1, 2, 3, 4, 5 };
        int[] input2 = new int[] { 10, 20, 30, 40, 50 };
        int[] intArray = ArrayUtils.concat(input1, input2);
        TestUtils.assertListElements(intArray, 1, 2, 3, 4, 5, 10, 20, 30, 40, 50);

    }
}
