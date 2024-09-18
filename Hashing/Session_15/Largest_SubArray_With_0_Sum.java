package Hashing.Session_15;

import java.util.HashMap;

public class Largest_SubArray_With_0_Sum {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int maxLength = maxLen(arr, n);
        System.out.println(maxLength);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param arr
     * @param n
     * @return
     */
    private static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, -1);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
