package Hashing.Session_11;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Cumulative_Frequency_Count_Of_Elements_In_Unsorted_Array
 */
public class Cumulative_Frequency_Count_Of_Elements_In_Unsorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 3, 4 };
        int[] freq = countFreq(nums);
        System.out.println(Arrays.toString(freq));
    }

    /**
     * Optimal Approach
     * 
     * TC: O(Nlog(N) + N) ~ O(Nlog(N))
     * SC: O(N)
     */
    private static int[] countFreq(int[] arr) {
        TreeMap<Integer, Integer> hm = new TreeMap<Integer, Integer>(); // SC: O(N)
        for (int it : arr) { // TC: O(N)
            hm.put(it, hm.getOrDefault(it, 0) + 1); // TC: O(log(N)) - ordered Map
        }
        int[] cumFreq = new int[hm.size()];
        int index = 0;
        int sum = 0;
        for (Integer key : hm.keySet()) { // TC: O(N)
            sum += hm.get(key);
            cumFreq[index++] = sum;
        }
        return cumFreq;
    }
}
