package DynamicProgramming.Session_12;

public class Minimum_Cost_To_Cross_Or_Reach_End_Of_Array {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8 };
        int minCost = getMinimumCost(arr);
        System.out.println(minCost);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param arr
     * @return
     */
    private static int getMinimumCost(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][3]; // SC: O(N)
        // dp[i][j] -> j is 1 for backward and 2 for forward movement
        dp[0][2] = arr[0];
        dp[0][1] = Integer.MAX_VALUE; // not possible to reach anyway
        dp[1][2] = Integer.MAX_VALUE; // not possible to reach anyway
        dp[1][1] = dp[0][2] + arr[2] + arr[1];
        int i = 2;
        for (i = 2; i < n - 1; i++) { // TC: O(N)
            dp[i][2] = arr[i] + Math.min(dp[i - 2][2], dp[i - 2][1]); // forward move
            dp[i][1] = dp[i - 1][2] + arr[i + 1] + arr[i]; // backward move
        }
        // here i = n - 1
        dp[i][2] = arr[n - 1] + Math.min(dp[i - 2][2], dp[i - 2][1]);
        dp[i][1] = Integer.MAX_VALUE; // not possible to reach anyway
        return Math.min(dp[n - 1][2], Math.max(dp[n - 1][2], dp[n - 1][1]));
    }
}
