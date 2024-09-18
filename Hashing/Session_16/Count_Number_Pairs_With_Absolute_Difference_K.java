package Hashing.Session_16;

import java.util.HashMap;

public class Count_Number_Pairs_With_Absolute_Difference_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1 };
        int k = 1;

        int countBF = countKDifferenceBruteForce(nums, k);
        System.out.println(countBF);

        int countOpt = countKDifferenceOptimal(nums, k);
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
    private static int countKDifferenceBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (Math.abs(nums[j] - nums[i]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static int countKDifferenceOptimal(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        int count = 0;
        for (int num : nums) { // TC: O(N)
            count += hm.getOrDefault(num + k, 0) + hm.getOrDefault(num - k, 0);
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
