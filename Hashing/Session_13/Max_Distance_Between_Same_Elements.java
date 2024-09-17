package Hashing.Session_13;

import java.util.ArrayList;
import java.util.HashMap;

public class Max_Distance_Between_Same_Elements {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2 };
        int maxDist = maxDistance(arr);
        System.out.println(maxDist);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    private static int maxDistance(int[] arr) {
        int n = arr.length;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], new ArrayList<Integer>());
            }
            hm.get(arr[i]).add(i);
        }
        int max = Integer.MIN_VALUE;
        for (Integer key : hm.keySet()) { // TC: O(N)
            ArrayList<Integer> list = hm.get(key);
            max = Math.max(max, list.get(list.size() - 1) - list.get(0));
        }
        return max;
    }
}
