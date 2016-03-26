import com.lange.exercise.algorithms.LongestIncresingSubsequenceSizeDPAlgorithm;
import com.lange.exercise.utils.StringUtils;

import java.util.List;
import java.util.Scanner;

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

            List<Integer> solution = LongestIncresingSubsequenceSizeDPAlgorithm.solve(input);

            System.out.println(String.format("input: [%s]\noutput: [%s]\n", StringUtils.arrJoiner(input), StringUtils.listJoiner(solution)));

            totalCases--;
        }
    }
}
