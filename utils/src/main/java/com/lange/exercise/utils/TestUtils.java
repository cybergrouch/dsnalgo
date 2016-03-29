package com.lange.exercise.utils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by lange on 27/3/16.
 */
public class TestUtils {

    public static void assertListElements(int[] actual, int... expected) {
        assertThat(actual).containsExactly(expected);
    }

}
