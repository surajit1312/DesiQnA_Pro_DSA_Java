package TwoPointers.Session_5;

import java.util.Arrays;

public class Number_Of_Pairs_Whose_Diff_Less_Than_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2 };
        int k = 2;

        int count = pairsWithDifferenceLessThanEqualsK(nums, k);
        System.out.println(count);
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
    private static int pairsWithDifferenceLessThanEqualsK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        long diff = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N + N), i and j both travels N
            diff = nums[j] - nums[i];
            while (diff > k) {
                i++;
                diff = nums[j] - nums[i];
            }
            count += j - i + 1;
        }
        return count - n;
    }
}
