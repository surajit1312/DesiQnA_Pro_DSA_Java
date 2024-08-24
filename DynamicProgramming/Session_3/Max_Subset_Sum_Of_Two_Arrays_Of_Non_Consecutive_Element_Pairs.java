package DynamicProgramming.Session_3;

public class Max_Subset_Sum_Of_Two_Arrays_Of_Non_Consecutive_Element_Pairs {
    public static void main(String[] args) {
        int n = 4;
        int[] nums1 = { 1, 5, 3, 21234 };
        int[] nums2 = { -4509, 200, 3, 40 };
        int maxSum = getMaxSum(nums1, nums2, n);
        System.out.println(maxSum);
    }

    private static int getMaxSum(int[] nums1, int[] nums2, int n) {
        int[] dp = new int[n];
        dp[0] = Math.max(Math.max(nums1[0], nums2[0]), 0);
        dp[1] = Math.max(nums1[1], nums2[1]); // cannot choose index 0
        /**
         * Manual calculation:
         * 
         * dp[2] = Math.max(x, y) where x and y are :
         * 
         * x is current max + best answer at index '0'
         * x = Math.max(nums1[2], nums2[2]) + dp[0]
         * 
         * y is best answer at index '1'
         * y = dp[1]
         */
        for (int i = 2; i < n; i++) {
            int x = Math.max(nums1[i], nums2[i]) + dp[i - 2];
            int y = dp[i - 1];
            dp[i] = Math.max(x, y);
        }
        return dp[n - 1];
    }
}
