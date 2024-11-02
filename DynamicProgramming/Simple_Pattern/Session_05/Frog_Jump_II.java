package DynamicProgramming.Simple_Pattern.Session_05;

public class Frog_Jump_II {
    public static void main(String[] args) {
        int n1 = 10;
        int k1 = 4;
        int[] heights1 = { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };
        int minCost1 = getMinimumCostInJump(heights1, n1, k1);
        System.out.println(minCost1);

        int n2 = 5;
        int k2 = 3;
        int[] heights2 = { 10, 30, 40, 50, 20 };
        int minCost2 = getMinimumCostInJump(heights2, n2, k2);
        System.out.println(minCost2);

        int n3 = 3;
        int k3 = 1;
        int[] heights3 = { 10, 20, 10 };
        int minCost3 = getMinimumCostInJump(heights3, n3, k3);
        System.out.println(minCost3);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param heights
     * @param n
     * @return
     */
    private static int getMinimumCostInJump(int[] heights, int n, int k) {
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        /**
         * manual calculation
         * 
         * dp[2] = Math.min(Math.abs(heights[2] - heights[1]) + dp[1],
         * Math.abs(heights[2] - heights[0]) + dp[0]);
         */
        for (int i = 2; i < n; i++) { // TC: O(N)
            int current = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    current = Math.min(current, Math.abs(heights[i] - heights[i - j]) + dp[i - j]);
                }
            }
            dp[i] = current;
        }
        return dp[n - 1];
    }
}
