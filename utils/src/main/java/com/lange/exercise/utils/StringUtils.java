package com.lange.exercise.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lange on 24/3/16.
 */
public class StringUtils {

    public static final String listJoiner(List<Integer> intList) {
        return intList.stream().map(object -> object.toString()).collect(Collectors.joining(","));
    }

    public static final String arrJoiner(int... elements) {
        return IntStream.of(elements).mapToObj(i -> ((Integer) i).toString()).collect(Collectors.joining(","));
    }
}
