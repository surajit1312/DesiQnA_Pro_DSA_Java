package Hashing.Session_0;

import java.util.Arrays;
import java.util.HashMap;

public class Max_Min_Frequency_Of_Numbers {
    public static void main(String[] args) {
        int n = 6;
        int[] nums = { 3, 2, 3, 2, 4, 3 };

        int[][] maxMinBF = getMaxMinNumbersBruteForce(nums, n);
        System.out.println(Arrays.deepToString(maxMinBF));

        int[][] maxMinOptimal = getMaxMinNumbersOptimal(nums, n);
        System.out.println(Arrays.deepToString(maxMinOptimal));
    }

    /**
     * Brute-Force approach
     * 
     * TC: O(N x N)
     * SC: O(N x N) ~ O(1) - ignored as needed for output
     * 
     * @param nums
     * @param n
     * @return
     */
    private static int[][] getMaxMinNumbersBruteForce(int[] nums, int n) {
        // SC: O(N x N)
        int[][] result = new int[2][2];
        int min = -1;
        int max = -1;
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int count = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count < minFreq) {
                minFreq = count;
                min = nums[i];
            }
            if (count > maxFreq) {
                maxFreq = count;
                max = nums[i];
            }
        }
        result[0] = new int[] { max, maxFreq };
        result[1] = new int[] { min, minFreq };
        return result;
    }

    /**
     * Optimal approach
     * 
     * TC: O(N + K) ~ O(2N) ~ O(N) (worst case)
     * SC: O(N x N + K) ~ O(K) ~ O(N) (worst case)
     * 
     * SC: O(N x N) - ignored as needed for output
     * 
     * @param nums
     * @param n
     * @return
     */
    private static int[][] getMaxMinNumbersOptimal(int[] nums, int n) {
        // SC: O(N x N)
        int[][] result = new int[2][2];
        int min = -1;
        int max = -1;
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = 0;

        // SC: O(K) - K distinct elements ~ O(N)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : hm.keySet()) { // TC: O(K) - K distinct elements ~ O(N)
            int freq = hm.get(key);
            if (freq < minFreq) {
                minFreq = freq;
                min = key;
            }
            if (freq > maxFreq) {
                maxFreq = freq;
                max = key;
            }
        }
        result[0] = new int[] { max, maxFreq };
        result[1] = new int[] { min, minFreq };
        return result;
    }
}
