package DynamicProgramming.Simple_Pattern.Session_06;

public class Max_Sum_Of_Journey {
    public static void main(String[] args) {
        int n = 8;
        int[] costs = { 5, 8, 3, 100, -5, -5, 5, 10 }; // steps allowed 1, 3 or 5
        int maxSum = maximumJourneySum(costs, n);
        System.out.println(maxSum);
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
    private static int maximumJourneySum(int[] costs, int n) {
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = costs[0];
        dp[1] = costs[1] + dp[0]; // costs[1] + costs[0];
        dp[2] = costs[2] + dp[1]; // costs[2] + costs[1] + costs[0];
        dp[3] = Math.max(costs[3] + dp[0], costs[3] + dp[2]);
        dp[4] = Math.max(costs[4] + dp[1], costs[4] + dp[3]);
        for (int i = 5; i < dp.length; i++) { // TC: O(N)
            dp[i] = Math.max(costs[i] + dp[i - 1], Math.max(costs[i] + dp[i - 3], Math.max(costs[i], dp[i - 5])));
        }
        return dp[n - 1];
    }
}
