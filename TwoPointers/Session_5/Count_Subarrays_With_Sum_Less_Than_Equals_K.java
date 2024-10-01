package TwoPointers.Session_5;

public class Count_Subarrays_With_Sum_Less_Than_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int k = 5;

        int countBF = countSubArraysBruteForce(nums, k);
        System.out.println(countBF);

        int countOpt = countSubArraysOptimal(nums, k);
        System.out.println(countOpt);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int countSubArraysBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            long sum = 0L;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int countSubArraysOptimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        long sum = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N + N), i and j both travels N
            sum += nums[j];
            while (sum > k) {
                sum -= nums[i];
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }
}
