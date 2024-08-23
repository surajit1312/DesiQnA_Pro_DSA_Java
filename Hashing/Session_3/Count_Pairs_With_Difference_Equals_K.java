package Hashing.Session_3;

import java.util.HashMap;

public class Count_Pairs_With_Difference_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 3, 4, 2 };
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
                if (nums[i] - nums[j] == k) {
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
            int offset = nums[i] + k;
            if (hm.containsKey(offset)) {
                count += hm.get(offset);
            }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
