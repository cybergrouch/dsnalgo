package com.lange.exercise.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lange on 24/3/16.
 */
public class StringUtils {

    public static final String listJoiner(List<Integer> intList) {
        return intList.stream().map(object -> object.toString()).collect(Collectors.joining(","));
    }
}
