package DynamicProgramming.Session_05;

public class Frog_Jump_I {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = { 10, 30, 40, 20 };
        int minCost = getMinimumCostInJump(heights, n);
        System.out.println(minCost);
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
    private static int getMinimumCostInJump(int[] heights, int n) {
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        /**
         * Manual calculation - jumps allowed is ith to (i + 1)th or (i + 2)th stone
         * 
         * dp[2] = Math.min(x, y) where x and y are:
         * 
         * int x (1 step) = Math.abs(heights[2] - heights[1]) + dp[1]
         * best answer to reach height at index 1 is added
         * 
         * int y (2 steps) = Math.abs(heights[2] - heights[0]) + dp[0]
         * best answer to reach height at index 0 is added
         */
        for (int i = 2; i < n; i++) { // TC: O(N)
            int x = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int y = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            dp[i] = Math.min(x, y);
        }
        return dp[n - 1];
    }
}
