package BinarySearch.Session_5;

public class Find_Nth_Root_Of_M {
    public static void main(String[] args) {
        int n = 7;
        int m = 78125;
        int rootValue = NthRoot(n, m);
        System.out.println(rootValue);
    }

    /**
     * TC: O(Nlog(M))
     * SC: O(1)
     */
    public static int NthRoot(int n, int m) {
        if (n == 1) {
            return m;
        }
        if (m == 1) {
            return 1;
        }
        int low = 2;
        int high = m;
        while (low <= high) { // TC: O(log(M))
            int mid = low + (high - low) / 2;
            double prod = product(mid, n); // TC: O(N)
            if (prod == m) {
                return mid;
            } else if (prod < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static double product(int num, int times) {
        double prod = 1;
        for (int i = 1; i <= times; i++) {
            prod *= num;
        }
        return prod;
    }
}
