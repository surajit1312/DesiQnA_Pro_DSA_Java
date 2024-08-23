package Hashing.Session_2;

import java.util.HashMap;

public class Count_Pairs_With_Sum_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 6;

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
                if (nums[i] + nums[j] == k) {
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
        // SC: O(N)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) { // TC: O(N)
            int diff = k - nums[i];
            if (hm.containsKey(diff)) {
                count = count + hm.get(diff);
            } else {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
