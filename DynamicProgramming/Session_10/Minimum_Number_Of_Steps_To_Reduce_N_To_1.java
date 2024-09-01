package DynamicProgramming.Session_10;

public class Minimum_Number_Of_Steps_To_Reduce_N_To_1 {
    public static void main(String[] args) {
        int n = 5;
        int steps = minSteps(n);
        System.out.println(steps);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param n
     * @return
     */
    private static int minSteps(int n) {
        int[] dp = new int[n + 1]; // SC: O(N)
        dp[1] = 0;
        // dp[2] = 1; // as 2 is divisible by 2
        // dp[3] = 1; // as 3 is divisible by 3
        for (int i = 2; i <= n; i++) { // TC: O(N)
            int x = 1 + dp[i - 1];
            int y = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                y = 1 + dp[i / 2];
            }
            int z = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                z = 1 + dp[i / 3];
            }
            dp[i] = Math.min(x, Math.min(y, z));
        }
        return dp[n];
    }
}
