package TwoPointers.Session_3;

import java.util.ArrayList;

public class Find_Closest_Pair_From_Two_Arrays {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[] arr = { 1, 4, 5, 7 };
        int[] brr = { 10, 20, 30, 40 };
        int x = 50;
        ArrayList<Integer> pair = printClosest(arr, brr, n, m, x);
        System.out.println(pair);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N + M)
     * SC: O(1)
     */
    public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int val1 = -1;
        int val2 = -1;
        // using the property of sorted Array
        int p = 0; // pointer for Array arr
        int q = m - 1; // pointer for Array brr
        int diff = Integer.MAX_VALUE;
        while (p < n && q >= 0) {
            if (arr[p] + brr[q] == x) {
                val1 = arr[p];
                val2 = brr[q];
                break;
            } else if (arr[p] + brr[q] < x) {
                if (diff > Math.abs(arr[p] + brr[q] - x)) {
                    diff = Math.abs(arr[p] + brr[q] - x);
                    val1 = arr[p];
                    val2 = brr[q];
                }
                p++;
            } else {
                if (diff > Math.abs(arr[p] + brr[q] - x)) {
                    diff = Math.abs(arr[p] + brr[q] - x);
                    val1 = arr[p];
                    val2 = brr[q];
                }
                q--;
            }
        }
        result.add(val1);
        result.add(val2);
        return result;
    }
}
