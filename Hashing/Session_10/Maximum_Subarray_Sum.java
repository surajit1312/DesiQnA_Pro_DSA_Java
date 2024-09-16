package Hashing.Session_10;

public class Maximum_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        long maxSumBF = getMaxSubArraySumBruteForce(nums);
        System.out.println(maxSumBF);

        long maxSumOpt = getMaxSubArraySumOptimal(nums);
        System.out.println(maxSumOpt);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @return
     */
    private static long getMaxSubArraySumBruteForce(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            long sum = 0L;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * Optimal Approach (Kadane's Algorithm)
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param nums
     * @return
     */
    private static long getMaxSubArraySumOptimal(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        long currentSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentSum += nums[i];
            max = Math.max(max, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return max;
    }
}
