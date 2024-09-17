package Hashing.Session_12;

import java.util.Arrays;

public class Cumulative_Sum_Query {
    public static void main(String[] args) {
        int n = 3;
        int[] nums = { 1, 4, 1 };
        int q = 3;
        int[][] queries = { { 1, 1 }, { 1, 2 }, { 0, 2 } };
        int[] querySums = getCumulativeSumFromQueries(n, nums, q, queries);
        System.out.println(Arrays.toString(querySums));
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N + Q)
     * SC: O(N)
     * 
     * @param n
     * @param nums
     * @param q
     * @param queries
     * @return
     */
    private static int[] getCumulativeSumFromQueries(int n, int[] nums, int q, int[][] queries) {
        int[] prefix = new int[n]; // SC: O(N)
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefix[i] = nums[i] + prefix[i - 1];
        }
        int[] cumSum = new int[q]; // SC: O(Q) ~ O(1), ignored as this is the returned result
        for (int i = 0; i < q; i++) { // TC: O(Q)
            if (queries[i][0] == 0) {
                cumSum[i] = prefix[queries[i][1]];
            } else {
                cumSum[i] = prefix[queries[i][1]] - prefix[queries[i][0] - 1];
            }
        }
        return cumSum;
    }
}
