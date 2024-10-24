package TwoPointers.Session_6;

import java.util.HashMap;

public class Maximum_SubArray_Length_With_Distinct_Numbers {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 1, 2, 3 };
        int n = arr.length;
        System.out.print(largestSubarray(arr, n));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     * 
     * @param arr
     * @param n
     * @return
     */
    private static int largestSubarray(int[] arr, int n) {
        int i = 0; // pointers
        int j = 0; // pointers
        int maxLength = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        while (i < n && j < n) { // TC: O(N)
            if (!hm.containsKey(arr[j])) {
                hm.put(arr[j], j);
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else {
                int idx = hm.get(arr[j]);
                while (i <= idx) {
                    hm.remove(arr[i]);
                    i++;
                }
                i = idx + 1;
                hm.put(arr[j], j);
                j++;
            }
        }
        return maxLength;
    }
}
