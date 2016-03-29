package com.lange.exercise.utils;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lange on 27/3/16.
 */
public class ArrayUtils {

    public static final int[] reverse(int[] input) {
        int[] sequence = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            sequence[i] = input[input.length - i - 1];
        }
        return sequence;
    }

    public static final int[] toIntArray(Stack<Integer> stack, boolean reversed) {
        int i = reversed ? stack.size() - 1 : 0;
        int[] sequence = new int[stack.size()];
        while(!stack.isEmpty()) {
            sequence[i] = stack.pop();
            if (reversed) {
                i--;
            } else {
                i++;
            }
        }
        return sequence;
    }

    public static final Stack<Integer> toStack(int[] input) {
        Stack<Integer> stack = new Stack<>();
        appendToStack(stack, input);
        return stack;
    }

    public static final int[] toIntArray(Stack<Integer> stack) {
        return toIntArray(stack, true);
    }

    public static final void appendToStack(Stack<Integer> stack, int[] input) {
        for (int inputValue : input) {
            stack.push(inputValue);
        }
    }

    public static int[] concat(int[] input1, int[] input2) {
        int size = input1.length + input2.length;
        int[] sequence = new int[size];
        for (int i = 0; i < input1.length; i++) {
            sequence[i] = input1[i];
        }

        for (int i = 0; i < input2.length; i++) {
            sequence[i + input1.length] = input2[i];
        }
        return sequence;
    }

    public static final String toString(int[] elements) {
        return IntStream.of(elements).mapToObj(i -> ((Integer) i).toString()).collect(Collectors.joining(","));
    }

    public static final Tail tail(int[] elements) {
        return new Tail(elements);
    }


    public static final Head head(int[] elements) {
        return new Head(elements);
    }

    public static class Tail {
        public int tail = -1;
        public int[] rest = null;

        public Tail(int[] input) {
            if (input == null || input.length == 0) {
                return;
            }

            tail = input[input.length - 1];

            if (input.length - 1 >= 1) {
                rest = new int[input.length - 1];
                System.arraycopy(input, 0, rest, 0, input.length - 1);
            }
        }
    }

    public static class Head {
        public int head = -1;
        public int[] rest = null;

        public Head(int[] input) {
            if (input == null || input.length == 0) {
                return;
            }

            head = input[0];

            if (input.length - 1 >= 1) {
                rest = new int[input.length - 1];
                System.arraycopy(input, 1, rest, 0, input.length - 1);
            }
        }
    }
}
