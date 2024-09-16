package Hashing.Session_7;

import java.util.HashMap;

public class Longest_SubArray_With_Sum_K {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        int largestSubArrayBF = lenOfLongSubarrBruteForce(arr, n, k);
        System.out.println(largestSubArrayBF);

        int largestSubArrayOpt = lenOfLongSubarrOptimal(arr, n, k);
        System.out.println(largestSubArrayOpt);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param arr
     * @param n
     * @param k
     * @return
     */
    public static int lenOfLongSubarrBruteForce(int[] arr, int n, int k) {
        int size = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                sum += arr[j];
                if (sum == k) {
                    size = Math.max(size, j - i + 1);
                }
            }
        }
        return size;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param arr
     * @param n
     * @param k
     * @return
     */
    public static int lenOfLongSubarrOptimal(int[] arr, int n, int k) {
        int size = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, -1); // <sum, index> -1 is index of 0 to calculate size = i - previndex
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                size = Math.max(size, i - hm.get(diff));
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return size;
    }
}
