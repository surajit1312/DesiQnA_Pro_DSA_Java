package Hashing.Session_4;

import java.util.HashMap;

public class Count_Pairs_With_Absolute_Difference_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 5, 9, 2, 12, 3 };
        int k = 2;

        int countPairsBF = countPairsBruteForce(nums, k);
        System.out.println(countPairsBF);

        int countPairsOpt = countPairsOptimal(nums, k);
        System.out.println(countPairsOpt);
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
    private static int countPairsBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < nums.length; j++) { // TC: O(N)
                if (Math.abs(nums[i] - nums[j]) == k) {
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
    private static int countPairsOptimal(int[] nums, int k) {
        int count = 0;
        // storing nums[i] and its frequency - SC: O(Q) ~ O(N) in worst case
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) { // TC: O(N)
            /**
             * |nums[i] - nums[j]| = k i.e. nums[i] - nums[j] is positive or negative
             * here |offset - nums[i]| = k
             * i.e. offset - nums[i] = k and -(offset - nums[i]) = k
             */
            int offset1 = nums[i] + k;
            int offset2 = nums[i] - k;
            if (hm.containsKey(offset1)) {
                count += hm.get(offset1);
            }
            if (hm.containsKey(offset2)) {
                count += hm.get(offset2);
            }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
