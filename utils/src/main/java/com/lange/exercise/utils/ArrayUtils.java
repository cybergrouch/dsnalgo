package com.lange.exercise.utils;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lange on 27/3/16.
 */
public class ArrayUtils {

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

    public static final int[] toIntArray(Stack<Integer> stack) {
        return toIntArray(stack, true);
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
        int tail = -1;
        int[] rest = null;

        public Tail(int[] input) {
            if (input == null || input.length == 0) {
                return;
            }

            tail = input[input.length - 1];

            if (input.length - 1 > 1) {
                rest = new int[input.length - 1];
                System.arraycopy(input, 0, rest, 0, input.length - 1);
            }
        }
    }

    public static class Head {
        int head = -1;
        int[] rest = null;

        public Head(int[] input) {
            if (input == null || input.length == 0) {
                return;
            }

            head = input[0];

            if (input.length - 1 > 1) {
                rest = new int[input.length - 1];
                System.arraycopy(input, 1, rest, 0, input.length - 1);
            }
        }
    }
}
