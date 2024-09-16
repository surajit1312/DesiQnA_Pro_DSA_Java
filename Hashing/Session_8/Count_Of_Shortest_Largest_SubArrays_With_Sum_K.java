package Hashing.Session_8;

import java.util.HashMap;

public class Count_Of_Shortest_Largest_SubArrays_With_Sum_K {
    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        int[] arr = { 1, 2, 3, 4, 2, 5 };
        int[] lengths = getShortestLargestSubArraysWithSumK(arr, n, k);
        int countMin = getCountOfSubArraysWithSum(arr, n, k, lengths[0]);
        int countMax = getCountOfSubArraysWithSum(arr, n, k, lengths[1]);
        System.out.println("Minimum length of sub-arrays : " + lengths[0] + " with count : " + countMin);
        System.out.println("Maximum length of sub-arrays : " + lengths[1] + " with count : " + countMax);
    }

    /**
     * TC: O(N)
     * SC: O(2N) ~ O(N)
     * 
     * @param arr
     * @param n
     * @param k
     * @return
     */
    private static int[] getShortestLargestSubArraysWithSumK(int[] arr, int n, int k) {
        int[] result = new int[2];
        HashMap<Integer, Integer> minHm = new HashMap<Integer, Integer>(); // SC: O(N)
        minHm.put(0, -1);
        HashMap<Integer, Integer> maxHm = new HashMap<Integer, Integer>(); // SC: O(N)
        maxHm.put(0, -1);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            int diff = sum - k;
            if (minHm.containsKey(diff)) {
                min = Math.min(min, i - minHm.get(diff));
            }
            if (maxHm.containsKey(diff)) {
                max = Math.max(max, i - maxHm.get(diff));
            }
            if (!minHm.containsKey(sum)) {
                minHm.put(sum, i);
            }
            if (!maxHm.containsKey(sum)) {
                maxHm.put(sum, i);
            }
        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param arr
     * @param n
     * @param k
     * @param targetLength
     * @return
     */
    private static int getCountOfSubArraysWithSum(int[] arr, int n, int k, int targetLength) {
        if (targetLength == 0) {
            return 0;
        }
        int sum = 0;
        int count = 0;
        for (int i = 0; i < targetLength; i++) {
            sum += arr[i];
        }
        if (sum == k) {
            count++;
        }
        for (int i = targetLength; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - targetLength];
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}
