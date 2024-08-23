package Hashing.Session_5;

import java.util.Arrays;

public class Sum_Of_Range_L_To_R_In_Array {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[][] queries = { { 3, 7 }, { 5, 8 } };

        int[] sumRangeBF = sumOfRangeBruteForce(nums, queries);
        System.out.println(Arrays.toString(sumRangeBF));

        int[] sumRangeOpt = sumOfRangeOptimal(nums, queries);
        System.out.println(Arrays.toString(sumRangeOpt));
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(Q x N)
     * SC: O(1) (O(N) is ignored as it is input)
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int[] sumOfRangeBruteForce(int[] nums, int[][] queries) {
        int q = queries.length;
        int[] sumRange = new int[q];
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int left = queries[i][0];
            int right = queries[i][1];
            int sum = 0;
            for (int j = left; j <= right; j++) { // TC: O(Right - Left + 1) ~ O(N)
                sum += nums[j];
            }
            sumRange[i] = sum;
        }
        return sumRange;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(Q + N)
     * SC: O(N)
     * 
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int[] sumOfRangeOptimal(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] sumRange = new int[q]; // SC: O(Q) - ignored as it is input

        int[] prefixSum = new int[n]; // SC: O(N)
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int left = queries[i][0];
            int right = queries[i][1];
            sumRange[i] = prefixSum[right] - prefixSum[left - 1];
        }
        return sumRange;
    }
}
