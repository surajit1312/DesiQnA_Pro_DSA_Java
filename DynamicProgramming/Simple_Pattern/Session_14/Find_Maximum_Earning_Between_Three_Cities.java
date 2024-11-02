package DynamicProgramming.Simple_Pattern.Session_14;

import java.util.Scanner;

/**
 * TC: O(N)
 * SC: O(3 x N) ~ O(N)
 */
public class Find_Maximum_Earning_Between_Three_Cities {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        long[] c = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scn.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            c[i] = scn.nextLong();
        }
        long[][] dp = new long[100005][3];
        dp[1][0] = a[1];
        dp[1][1] = b[1];
        dp[1][2] = c[1];
        for (int i = 2; i <= n; i++) { // TC: O(N)
            // best answer till index i where i is considered from array 'a'
            dp[i][0] = a[i] + Math.max(dp[i - 1][0], Math.max(dp[i - 2][1], dp[i - 2][2]));
            // best answer till index i where i is considered from array 'b'
            dp[i][1] = b[i] + Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 2][2]));
            // best answer till index i where i is considered from array 'c'
            dp[i][2] = c[i] + Math.max(dp[i - 1][2], Math.max(dp[i - 2][0], dp[i - 2][1]));
        }
        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        scn.close();
    }
}
