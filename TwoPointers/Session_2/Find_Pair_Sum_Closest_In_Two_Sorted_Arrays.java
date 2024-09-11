package TwoPointers.Session_2;

public class Find_Pair_Sum_Closest_In_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] A = { 2, 5, 8, 10, 15 };
        int[] B = { 3, 5, 8, 8, 10 };
        int target = 11;

        int pairSumBF = findPairSumBruteForce(A, B, target);
        System.out.println(pairSumBF);

        int pairSumOptimal = findPairSumOptimal(A, B, target);
        System.out.println(pairSumOptimal);
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(M x N)
     * SC: O(1)
     * 
     * @param A
     * @param B
     * @param target
     * @return
     */
    private static int findPairSumBruteForce(int[] A, int[] B, int target) {
        int m = A.length;
        int n = B.length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (A[i] + B[j] <= target) {
                    result = Math.max(result, A[i] + B[j]);
                }
            }
        }
        return result;
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(M x N)
     * SC: O(1)
     * 
     * @param A
     * @param B
     * @param target
     * @return
     */
    private static int findPairSumOptimal(int[] A, int[] B, int target) {
        int m = A.length;
        int n = B.length;
        int result = Integer.MIN_VALUE;

        // using the property of sorted Array
        int p = 0; // pointer for Array A
        int q = n - 1; // pointer for Array B
        while (p < m && q >= 0) {
            if (A[p] + B[q] <= target) {
                result = Math.max(result, A[p] + B[q]);
                p++;
            } else {
                q--;
            }
        }
        return result;
    }
}
