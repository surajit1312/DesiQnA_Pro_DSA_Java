package Hashing.Session_11;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 22;

        int[] indicesBF = twoSumBruteForce(nums, target);
        System.out.println(Arrays.toString(indicesBF));

        int[] indicesOpt = twoSumOptimal(nums, target);
        System.out.println(Arrays.toString(indicesOpt));
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i };
            } else {
                hm.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }
}
