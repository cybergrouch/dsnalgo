import com.lange.exercise.algorithms.LongestIncresingSubsequenceSizeAlgorithm;
import com.lange.exercise.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by lange on 24/3/16.
 */
public class LongestIncresingSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCases = scanner.nextInt();

        while (totalCases > 0) {
            int caseSize = scanner.nextInt();
            int[] input = new int[caseSize];

            for (int i = 0; i < caseSize; i++) {
                input[i] = scanner.nextInt();
            }

            List<Integer> solution = LongestIncresingSubsequenceSizeAlgorithm.solve(input);

            System.out.println(String.format("input: [%s]\noutput: [%s]\n", StringUtils.arrJoiner(input), StringUtils.listJoiner(solution)));

            totalCases--;
        }
    }
}
