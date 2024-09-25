package BinarySearch.Session_15;

import java.util.ArrayList;
import java.util.Arrays;

public class Counting_Elements_In_Two_Arrays {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        int[] arr1 = { 4, 8, 7, 5, 1 };
        int[] arr2 = { 4, 48, 3, 0, 1, 1, 5 };
        ArrayList<Integer> counts = countEleLessThanOrEqual(arr1, arr2, m, n);
        System.out.println(counts);
    }

    /**
     * TC: O((M + N) x log(N))
     * SC: O(1)
     */
    private static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
        Arrays.sort(arr2); // TC: O(Nlog(N))
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) { // TC: O(M)
            result.add(upperBound(arr2, n, arr1[i])); // TC: O(log(N))
        }
        return result;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private static int upperBound(int[] arr2, int n, int x) {
        int low = 0;
        int high = n - 1;
        int minIndex = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr2[mid] > x) {
                minIndex = Math.min(minIndex, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minIndex;
    }
}
