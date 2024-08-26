package DynamicProgramming.Session_8;

import java.util.Arrays;

public class Number_Of_Journeys_Odd_Even_Sum {
    public static void main(String[] args) {
        int n = 5;
        int[] journey = { 2, 3, 5, 8, 10 };
        int[] numberOfJourneys = getNumberOfOddEvenJourneys(journey, n);
        System.out.println(Arrays.toString(numberOfJourneys));
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param journey
     * @param n
     * @return
     */
    private static int[] getNumberOfOddEvenJourneys(int[] journey, int n) {
        int[][] dp = new int[n][2]; // 2 size is for odd => 1 and even => 0 // SC: O(2N) ~ O(N)
        dp[0][0] = journey[0] % 2 == 0 ? 1 : 0; // even
        dp[0][1] = journey[0] % 2 == 0 ? 0 : 1; // odd
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (journey[i] % 2 == 0) {
                // journey[i] is even
                dp[i][0] = dp[i - 1][0]; // even sum journey
                dp[i][1] = dp[i - 1][1]; // odd sum journey
                if (i > 1) {
                    dp[i][0] += dp[i - 2][0];
                    dp[i][1] += dp[i - 2][1];
                }
            } else {
                // journey[i] is odd
                dp[i][0] = dp[i - 1][1]; // even sum journey
                dp[i][1] = dp[i - 1][0]; // odd sum journey
                if (i > 1) {
                    dp[i][0] += dp[i - 2][1];
                    dp[i][1] += dp[i - 2][0];
                }
            }
        }
        return new int[] { dp[n - 1][1], dp[n - 1][0] };
    }
}
