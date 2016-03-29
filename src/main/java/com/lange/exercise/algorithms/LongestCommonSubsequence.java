package com.lange.exercise.algorithms;

import com.lange.exercise.utils.StringUtils;

import java.util.Scanner;

/**
 * Created by lange on 24/3/16.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCases = scanner.nextInt();

        while (totalCases > 0) {
            int caseSize1 = scanner.nextInt();
            int[] input1 = new int[caseSize1];

            for (int i = 0; i < caseSize1; i++) {
                input1[i] = scanner.nextInt();
            }

            int caseSize2 = scanner.nextInt();
            int[] input2 = new int[caseSize2];

            for (int i = 0; i < caseSize2; i++) {
                input2[i] = scanner.nextInt();
            }

            int[] solution = LongestCommonSubsequenceRecursiveAlgorithm.createInstance().solve(input1, input2);

            System.out.println(String.format("input1: [%s]\ninput2: [%s]\noutput: [%s]\n",
                    StringUtils.arrJoiner(input1),
                    StringUtils.arrJoiner(input2),
                    StringUtils.arrJoiner(solution)));

            totalCases--;
        }
    }
}
