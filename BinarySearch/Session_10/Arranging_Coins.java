package BinarySearch.Session_10;

public class Arranging_Coins {
    public static void main(String[] args) {
        int n = 5;
        int completedRows = arrangeCoins(n);
        System.out.println(completedRows);
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private static int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        long low = 1L;
        long high = (long) n;
        long completed = Long.MIN_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long calc = calculate(mid);
            if (calc == n) {
                return (int) mid;
            } else if (calc > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
                completed = Math.max(completed, mid);
            }
        }
        return (int) completed;
    }

    /**
     * TC: O(1)
     */
    private static long calculate(long k) {
        return (k * (k + 1)) / 2;
    }
}
