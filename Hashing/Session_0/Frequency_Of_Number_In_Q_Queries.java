package Hashing.Session_0;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Frequency_Of_Number_In_Q_Queries
 */
public class Frequency_Of_Number_In_Q_Queries {
    public static void main(String[] args) {
        int n = 6;
        int[] nums = { 6, 6, 6, 6, 2, 2 };
        int q = 2;
        int[] queries = { 6, 1 };

        int[] freqBF = getFrequencyBruteForce(nums, n, queries, q);
        System.out.println(Arrays.toString(freqBF));

        int[] freqOptimal = getFrequencyOptimal(nums, n, queries, q);
        System.out.println(Arrays.toString(freqOptimal));
    }

    /**
     * Brute-Force approach
     * 
     * TC: O(Q x N)
     * SC: O(Q) ~ O(1) - ignored as needed for output
     * 
     * @param nums
     * @param n
     * @param queries
     * @param q
     * @return
     */
    private static int[] getFrequencyBruteForce(int[] nums, int n, int[] queries, int q) {
        int[] freq = new int[q]; // SC: O(Q)
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int count = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (nums[j] == queries[i]) {
                    count++;
                }
            }
            freq[i] = count;
        }
        return freq;
    }

    /**
     * Optimal approach
     * 
     * TC: O(Q + N)
     * SC: O(Q + Q) ~ O(Q)
     * 
     * Q(Q) for int[] freq is ignored as needed for output
     * 
     * @param nums
     * @param n
     * @param queries
     * @param q
     * @return
     */
    private static int[] getFrequencyOptimal(int[] nums, int n, int[] queries, int q) {
        int[] freq = new int[q]; // SC: O(Q)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(Q)
        for (int i = 0; i < n; i++) { // TC: O(N)
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            freq[i] = hm.getOrDefault(queries[i], 0);
        }
        return freq;
    }
}
