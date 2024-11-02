package DynamicProgramming.Simple_Pattern.Session_02;

public class Max_Subset_Sum_In_Array_Of_Non_Adjacent_Elements {
    public static void main(String[] args) {
        int n = 5;
        int[] nums = { 1, -100, 2, 4, 5 };
        int maxSum = getMaxSum(nums, n);
        System.out.println(maxSum);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param n
     * @return
     */
    private static int getMaxSum(int[] nums, int n) {
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = Math.max(nums[0], 0); // consider no subset is chosen i.e. {}
        dp[1] = Math.max(nums[1], Math.max(nums[0], 0));
        /**
         * manual calculation
         * dp[2] = Math.max(x, y)
         * x = nums[2] + dp[0] <- nums[2] + Best answet till 0th index (include index)
         * y = dp[1] <- Best answet till 0th index (don't include index)
         */
        for (int i = 2; i < n; i++) { // TC: O(N)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
