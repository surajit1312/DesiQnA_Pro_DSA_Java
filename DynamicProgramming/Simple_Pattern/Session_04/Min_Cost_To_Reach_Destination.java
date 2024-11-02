package DynamicProgramming.Simple_Pattern.Session_04;

public class Min_Cost_To_Reach_Destination {
    public static void main(String[] args) {
        int n = 6;
        int[] costs = { 4, 12, 13, 18, 10, 12 };
        int minCost = getMinimumCost(costs, n);
        System.out.println(minCost);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param costs
     * @param n
     * @return
     */
    private static int getMinimumCost(int[] costs, int n) {
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = 0;
        dp[1] = Math.abs(costs[1] - costs[0]);
        dp[2] = Math.abs(costs[2] - costs[1]) + dp[1];
        /**
         * Manual calculation
         * 
         * dp[3] = Math.min(x, y) where x and y are:
         * int x = Math.abs(costs[3] - costs[2]) + dp[2]
         * in x, best cost to reach at 2 is added
         * int y = Math.abs(costs[3] - costs[0]) + dp[0]
         * in y, best cost to reach at 0 is added
         * as ith traveller can travel from i to (i + 1)th or (i + 3)th airport
         */
        for (int i = 3; i < n; i++) { // TC: O(N)
            int x = Math.abs(costs[i] - costs[i - 1]) + dp[i - 1];
            int y = Math.abs(costs[i] - costs[i - 3]) + dp[i - 3];
            dp[i] = Math.min(x, y);
        }
        return dp[n - 1];
    }
}
