package Hashing.Session_17;

import java.util.HashMap;
import java.util.Map;

/**
 * SubArrays_With_Sum_K
 */
public class SubArrays_With_Sum_K {
    public static void main(String[] args) {
        int N = 5;
        int[] Arr = { 10, 2, -2, -20, 10 };
        int k = -10;

        int countBF = findSubArraySumBruteForce(Arr, N, k);
        System.out.println(countBF);

        int countOpt = findSubArraySumOptimal(Arr, N, k);
        System.out.println(countOpt);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N^2)
     * SC: O(1)
     * 
     * @param Arr
     * @param N
     * @param k
     * @return
     */
    private static int findSubArraySumBruteForce(int Arr[], int N, int k) {
        int count = 0;
        for (int i = 0; i < N; i++) { // TC: O(N)
            int sum = 0;
            for (int j = i; j < N; j++) { // TC: O(N)
                sum += Arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(N)
     * 
     * @param nums
     * @param n
     * @param k
     * @return
     */
    private static int findSubArraySumOptimal(int Arr[], int N, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, 1);
        int sum = 0;
        for (int i = 0; i < N; i++) { // TC: O(N)
            sum += Arr[i];
            int diff = sum - k;
            if (hm.containsKey(diff)) {
                count += hm.get(diff);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
