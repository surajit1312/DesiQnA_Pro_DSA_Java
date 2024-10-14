package DynamicProgramming.Session_03;

public class Max_Subset_Sum_Of_Two_Arrays_Of_Non_Consecutive_Element_Pairs {
    public static void main(String[] args) {
        int n = 5;
        int[] nums1 = { -1, -2, 4, -4, 5 };
        int[] nums2 = { -1, -2, -3, 4, 10 };
        int maxSum = getMaxSum(nums1, nums2, n);
        System.out.println(maxSum);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums1
     * @param nums2
     * @param n
     * @return
     */
    private static int getMaxSum(int[] nums1, int[] nums2, int n) {
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = Math.max(Math.max(nums1[0], nums2[0]), 0); // best answer till index 0
        dp[1] = Math.max(Math.max(nums1[1], nums2[1]), 0); // best answer till index 1 (cannot choose index 0)
        // dp[2] = Math.max(Math.max(nums1[2], nums2[2]) + dp[0], dp[1]); // best answer
        // till index 2
        for (int i = 2; i < n; i++) { // TC: O(N)
            dp[i] = Math.max(Math.max(nums1[i], nums2[i]) + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
