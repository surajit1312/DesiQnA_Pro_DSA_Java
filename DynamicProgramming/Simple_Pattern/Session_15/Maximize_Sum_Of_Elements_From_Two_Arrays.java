package DynamicProgramming.Simple_Pattern.Session_15;

import java.util.Scanner;

public class Maximize_Sum_Of_Elements_From_Two_Arrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] b = new long[n + 1];
        long[] c = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = scn.nextLong();
            c[i] = scn.nextLong();
        }
        long[][][] dp = new long[100005][3][3];
        // we took index 1 and picked [1][2] => [b[index - 1]][b[index]]
        dp[1][1][1] = b[1]; // pick from array 'b'
        dp[1][1][2] = b[1]; // pick from array 'b'
        dp[1][2][1] = c[1]; // pick from array 'd'
        dp[1][2][2] = c[1]; // pick from array 'd'

        for (int i = 2; i <= n; i++) {
            dp[i][1][1] = b[i] + b[i - 1] + Math.max(dp[i - 2][2][2], dp[i - 2][2][1]);
            dp[i][1][2] = b[i] + c[i - 1] + Math.max(dp[i - 2][1][1], Math.max(dp[i - 2][2][1], dp[i - 2][1][2]));
            dp[i][2][1] = c[i] + b[i - 1] + Math.max(dp[i - 2][2][2], Math.max(dp[i - 2][2][1], dp[i - 2][1][2]));
            dp[i][2][2] = c[i] + c[i - 1] + Math.max(dp[i - 2][1][1], dp[i - 2][1][2]);
        }
        System.out.println(Math.max(dp[n][1][1], Math.max(dp[n][1][2], Math.max(dp[n][2][1], dp[n][2][2]))));
        scn.close();
    }
}
