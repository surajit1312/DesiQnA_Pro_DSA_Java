package TwoPointers.Session_5;

import java.util.HashMap;

public class Count_Subarrays_With_Count_Distinct_Numbers_Less_Than_Equals_K {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 3;

        int countOpt = countSubArraysOptimal(nums, k);
        System.out.println(countOpt);
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
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N + N), i and j both travels N
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            while (hm.size() > k) {
                int size = hm.get(nums[i]);
                hm.put(nums[i], size - 1);
                if (size - 1 == 0) {
                    hm.remove(nums[i]);
                }
                i++;
            }
            count += j - i + 1;
        }
        return count;
    }
}
