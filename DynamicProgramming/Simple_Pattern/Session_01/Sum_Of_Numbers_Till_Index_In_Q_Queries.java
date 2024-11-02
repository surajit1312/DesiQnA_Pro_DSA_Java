package DynamicProgramming.Simple_Pattern.Session_01;

import java.util.Arrays;

/**
 * Sum_Of_Numbers_Till_Index_In_Q_Queries
 */
public class Sum_Of_Numbers_Till_Index_In_Q_Queries {
    public static void main(String[] args) {
        int n = 5; // size of the array
        int[] nums = { 6, 7, 3, 2, 2 };
        int q = 4; // number of queries
        int[] queries = { 0, 3, 4, 2 }; // query array
        int[] sumQueries = sumOfNumbers(nums, n, queries, q);
        System.out.println(Arrays.toString(sumQueries));
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N + Q)
     * SC: O(N)
     * 
     * @param nums
     * @param n
     * @param queries
     * @param q
     * @return
     */
    private static int[] sumOfNumbers(int[] nums, int n, int[] queries, int q) {
        int[] sumQueries = new int[q];
        // create an empty dp array
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = nums[0];
        /**
         * manual calculations:
         * 
         * dp[1] = dp[0] + nums[1];
         * dp[2] = dp[1] + nums[2]; and so on
         */
        for (int i = 1; i < n; i++) { // TC: O(N)
            dp[i] = dp[i - 1] + nums[i];
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            sumQueries[i] = dp[queries[i]];
        }
        return sumQueries;
    }
}
