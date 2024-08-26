package DynamicProgramming.Session_9;

public class Minimum_Cost_To_Reduce_N_To_One {
    public static void main(String[] args) {
        int n = 15;
        int y = 100; // minus1
        int x = 1; // by7
        int z = 500; // by3
        int b = 10000000; // by5
        int minCost = getMinCostToReduceNToOne(n, y, x, z, b);
        System.out.println(minCost);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param n
     * @param y
     * @param x
     * @param z
     * @param b
     * @return
     */
    private static int getMinCostToReduceNToOne(int n, int y, int x, int z, int b) {
        int[] dp = new int[n + 1]; // SC: O(N)
        dp[1] = 0;
        // dp[2] = y + dp[0];
        // dp[3] = Math.min(y + dp[2], z + dp[1]);
        for (int i = 2; i <= n; i++) { // TC: O(N)
            int choice1 = y + dp[i - 1];
            int choice2 = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                choice2 = z + dp[i / 3];
            }
            int choice3 = Integer.MAX_VALUE;
            if (i % 5 == 0) {
                choice3 = b + dp[i / 5];
            }
            int choice4 = Integer.MAX_VALUE;
            if (i % 7 == 0) {
                choice4 = x + dp[i / 7];
            }
            dp[i] = Math.min(choice1, Math.min(choice2, Math.min(choice3, choice4)));
        }
        return dp[n];
    }
}
