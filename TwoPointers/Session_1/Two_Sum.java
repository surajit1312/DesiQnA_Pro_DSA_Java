package TwoPointers.Session_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two_Sum
 */
public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] indicesBF = twoSumBruteForce(nums, target);
        System.out.println(Arrays.toString(indicesBF));

        int[] indicesBetter = twoSumBetter(nums, target);
        System.out.println(Arrays.toString(indicesBetter));

        int[] indicesOptimal = twoSumOptimal(nums, target);
        System.out.println(Arrays.toString(indicesOptimal));
    }

    /**
     * Optimal Approach (Using HashMap)
     * TC: O(N)
     * SC: O(N)
     */
    private static int[] twoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i };
            }
            hm.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    /**
     * Better Approach (Using Two Pointers)
     * TC: O(2N + Nlog(N)) ~ O(Nlog(N))
     * SC: O(2N) ~ O(N)
     */
    private static int[] twoSumBetter(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        Map<Integer, ArrayList<Integer>> dup = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], i);
            } else {
                dup.put(nums[i], new ArrayList<Integer>());
                dup.get(nums[i]).add(hm.get(nums[i]));
                dup.get(nums[i]).add(hm.get(i));
                hm.put(nums[i], i);
            }
        }
        Arrays.sort(nums); // TC: O(Nlog(N))
        int p = 0;
        int q = n - 1;
        while (p < q) { // TC: O(N)
            if (nums[p] + nums[q] == target) {
                int index1 = hm.get(nums[p]);
                int index2 = hm.get(nums[q]);
                if (nums[p] == nums[q]) {
                    index1 = dup.get(nums[p]).get(0);
                }
                return new int[] { index1, index2 };
            } else if (nums[p] + nums[q] < target) {
                p++;
            } else {
                q--;
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * Brute-Force Approach
     * TC: O(N^2)
     * SC: O(1)
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
