package Hashing.Session_1;

import java.util.HashMap;

/**
 * Equal_Number_At_Distance_Less_Than_Equals_K
 */
public class Equal_Number_At_Distance_Less_Than_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 1, 2, 3 };
        int k = 2;

        boolean containsSameNumberBF = containsSameNumberBruteForce(nums, k);
        System.out.println(containsSameNumberBF);

        boolean containsSameNumberOptimal = containsSameNumberOptimal(nums, k);
        System.out.println(containsSameNumberOptimal);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N x K) ~ O(N^2)
     * SC: O(1)
     * 
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsSameNumberBruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) { // TC: O(N)
            for (int j = i + 1; j <= i + k; j++) { // TC: O(K)
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
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
    private static boolean containsSameNumberOptimal(int[] nums, int k) {
        // stores nums[i] and its index i in HashMap - SC: O(N)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) { // TC: O(N)
            if (hm.containsKey(nums[i]) && i - hm.get(nums[i]) <= k) {
                return true;
            } else {
                hm.put(nums[i], i);
            }
        }
        return false;
    }
}
