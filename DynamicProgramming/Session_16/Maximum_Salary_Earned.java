package DynamicProgramming.Session_16;

import java.util.Scanner;

/**
 * TC: O(N)
 * SC: O(N)
 */
public class Maximum_Salary_Earned {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();
        int[][] data = new int[n][t];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t; j++) {
                data[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[100005][3]; // SC: O(N)
        dp[1][0] = data[0][0]; // [1, 0] => best answer at index 1 for easy task
        dp[1][1] = data[0][1]; // [1, 1] => best answer at index 1 for hard task
        dp[1][2] = 0; // [1, 2] => best answer at index 1 for no task

        // dp[2][0] = data[1][0] + Math.max(dp[1][0], Math.max(dp[1][1], dp[1][2]));
        // dp[2][1] = data[1][1] + dp[1][2]; // to carry out hard task on day 2 no task
        // has been performed on day 1
        // dp[2][2] = Math.max(dp[1][0], Math.max(dp[1][1], dp[1][2]));
        // dp[3][0] = data[2][0] + Math.max(dp[2][0], Math.max(dp[2][1], dp[2][2]));
        // dp[3][1] = data[2][1] + dp[2][2];
        // dp[3][2] = Math.max(dp[2][0], Math.max(dp[2][1], dp[2][2]));

        for (int i = 2; i <= n; i++) { // TC: O(N)
            dp[i][0] = data[i - 1][0] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])); // easy task at
                                                                                                      // ith day
            dp[i][1] = data[i - 1][1] + dp[i - 1][2]; // hard task at ith day
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])); // no task at ith day
        }
        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        scn.close();
    }
}
