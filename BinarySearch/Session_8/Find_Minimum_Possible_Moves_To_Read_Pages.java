package BinarySearch.Session_8;

/**
 * Find_Minimum_Possible_Moves_To_Read_Pages
 */
public class Find_Minimum_Possible_Moves_To_Read_Pages {
    public static void main(String[] args) {
        int n = 3;
        int d = 4;
        int[] pages = { 2, 4, 3 };

        int minMovesBF = getMinimumPossibleMovesBruteForce(pages, n, d);
        System.out.println(minMovesBF);

        int minMovesOpt = getMinimumPossibleMovesOptimal(pages, n, d);
        System.out.println(minMovesOpt);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N + N x log(N)) ~ O(Nlog(H))
     * SC: O(1)
     * 
     * @param pages
     * @param n
     * @param d
     * @return
     */
    private static int getMinimumPossibleMovesOptimal(int[] pages, int n, int d) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, pages[i]);
        }
        int minK = Integer.MAX_VALUE;
        while (low <= high) { // TC: O(log(H))
            int mid = low + (high - low) / 2;
            if (isPossibleMove(pages, mid, d)) {
                minK = Math.min(minK, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minK;
    }

    /**
     * Brute-Force Approach
     * 
     * TC: O(N + H x N) ~ O(H x N)
     * SC: O(1)
     * 
     * @param pages
     * @param n
     * @param d
     * @return
     */
    private static int getMinimumPossibleMovesBruteForce(int[] pages, int n, int d) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            high = Math.max(high, pages[i]);
        }
        for (int i = low; i <= high; i++) { // TC: O(H)
            if (isPossibleMove(pages, i, d)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isPossibleMove(int[] pages, int k, int d) {
        int moves = 0;
        for (int i = 0; i < pages.length; i++) { // TC: O(N)
            moves += pages[i] % k == 0 ? (pages[i] / k) : (pages[i] / k) + 1;
        }
        return moves <= d;
    }
}
