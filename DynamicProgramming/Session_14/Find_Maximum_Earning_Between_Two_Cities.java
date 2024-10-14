package DynamicProgramming.Session_14;

import java.util.Scanner;

/**
 * TC: O(N)
 * SC: O(2N + K) ~ O(N)
 */
public class Find_Maximum_Earning_Between_Two_Cities {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] a = new long[n + 1]; // SC: O(N)
        long[] b = new long[n + 1]; // SC: O(N)
        for (int i = 1; i <= n; i++) {
            a[i] = scn.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scn.nextLong();
        }
        long[][] dp = new long[100005][2]; // SC: O(K)
        dp[1][0] = a[1];
        dp[1][1] = b[1];
        for (int i = 2; i <= n; i++) { // TC: O(N)
            // best answer till index i where i is considered from array 'a'
            dp[i][0] = Math.max(a[i] + dp[i - 1][0], a[i] + dp[i - 2][1]);
            // best answer till index i where i is considered from array 'b'
            dp[i][1] = Math.max(b[i] + dp[i - 1][1], b[i] + dp[i - 2][0]);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
        scn.close();
    }
}
