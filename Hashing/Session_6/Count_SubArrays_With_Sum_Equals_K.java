package Hashing.Session_6;

import java.util.HashMap;
import java.util.Map;

public class Count_SubArrays_With_Sum_Equals_K {
    public static void main(String[] args) {
        int n = 6;
        int[] nums = { 1, 0, 1, 2, 10, 8 };
        int k = 3;

        int countBF = countSubArraysWithSumKBruteForce(nums, n, k);
        System.out.println(countBF);

        int countOpt = countSubArraysWithSumKOptimal(nums, n, k);
        System.out.println(countOpt);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static int countSubArraysWithSumKBruteForce(int[] nums, int n, int k) {
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static int countSubArraysWithSumKOptimal(int[] nums, int n, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        // count of 0 is set to 1 so that if nums[0] == k then we can set count = 1
        hm.put(0, 1); // <sum, count>
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += nums[i];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                count += hm.get(diff);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
