package Hashing.Session_17;

import java.util.HashMap;

public class Count_Number_Of_SubArrays_Having_Given_XOR {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int m = 6;
        int count = countSubArraysWithXOR(arr, m);
        System.out.println(count);
    }

    /**
     * Optimal Approach
     *
     * TC: O(2N) ~ O(N)
     * SC: O(2N) ~ O(N)
     * 
     * @param arr
     * @param m
     * @return
     */
    private static int countSubArraysWithXOR(int[] arr, int m) {
        int n = arr.length;
        int count = 0;
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>(); // SC: O(N)
        int[] xor = new int[n]; // SC: O(N)
        xor[0] = arr[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            xor[i] = xor[i - 1] ^ arr[i];
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            int temp = m ^ xor[i];
            if (hMap.containsKey(temp)) {
                count += hMap.get(temp);
            }
            hMap.put(xor[i], hMap.getOrDefault(xor[i], 0) + 1);
            if (xor[i] == m) {
                count++;
            }
        }
        return count;
    }
}
