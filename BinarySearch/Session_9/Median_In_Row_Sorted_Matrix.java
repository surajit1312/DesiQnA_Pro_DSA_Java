package BinarySearch.Session_9;

import java.util.Arrays;

/**
 * Median_In_Row_Sorted_Matrix
 */
public class Median_In_Row_Sorted_Matrix {
    public static void main(String[] args) {
        int R = 3;
        int C = 3;
        int[][] M = {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };

        int medianBF = medianBruteForce(M, R, C);
        System.out.println(medianBF);

        int medianOpt = medianOptimal(M, R, C);
        System.out.println(medianOpt);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(R x C) + O(R x C x log(R x C)) ~ O(R x C x log(R x C))
     * SC: O(R x C)
     * 
     * @param matrix
     * @param R
     * @param C
     * @return
     */
    private static int medianBruteForce(int matrix[][], int R, int C) {
        int[] sorted = new int[R * C];
        int k = 0;
        for (int i = 0; i < R; i++) { // TC: O(R)
            for (int j = 0; j < C; j++) { // TC: O(C)
                sorted[k++] = matrix[i][j];
            }
        }
        Arrays.sort(sorted); // TC: O(R x C x log(R x C))
        /**
         * R and C are odd i.e. number of elements is R x C which is odd
         * so we have only 1 element as median
         */
        int medianIndex = (R * C) / 2;
        return sorted[medianIndex];
    }

    /**
     * TC: O(R) + O(Rlog(C)) ~ O(Rlog(C))
     * SC: O(1)
     * 
     * @param matrix
     * @param R
     * @param C
     * @return
     */
    private static int medianOptimal(int matrix[][], int R, int C) {
        // finding range
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) { // TC: O(R)
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }
        /**
         * R and C are odd i.e. number of elements is R x C which is odd
         * so we have only 1 element as median
         */
        int targetIndex = (R * C) / 2;
        // Applying Binary Search
        while (low <= high) { // TC: O(log(Range)) where Range = high - low i.e. constant
            int mid = low + (high - low) / 2;
            // find number of elements less than mid value in matrix
            int lessThanEquals = getLessThanEquals(matrix, R, C, mid);
            if (lessThanEquals <= targetIndex) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * TC: O(Rlog(C))
     * SC: O(1)
     * 
     * @param matrix
     * @param R
     * @param C
     * @param mid
     * @return
     */
    private static int getLessThanEquals(int[][] matrix, int R, int C, int mid) {
        // finding sum of occurences of mid value in each row
        int count = 0;
        for (int i = 0; i < R; i++) {
            count += getUpperBound(matrix[i], mid);
        }
        return count;
    }

    /**
     * TC: O(log(C))
     * SC: O(1)
     * 
     * @param row
     * @param k
     * @return
     */
    private static int getUpperBound(int[] row, int k) {
        int low = 0;
        int high = row.length - 1;
        int lessThan = row.length;
        // Applying Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] > k) {
                lessThan = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lessThan;
    }
}
