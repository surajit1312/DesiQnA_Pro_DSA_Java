package DynamicProgramming.Session_07;

public class Total_Points_Of_Happiness {
    public static void main(String[] args) {
        int n = 7;
        int[] a = { 6, 8, 2, 7, 4, 2, 7 };
        int[] b = { 7, 8, 5, 8, 6, 3, 5 };
        int[] c = { 8, 3, 2, 6, 8, 4, 1 };
        int totalPoints = getTotalPointsOfHappiness(a, b, c, n);
        System.out.println(totalPoints);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(3N) ~ O(N)
     * 
     * @param a
     * @param b
     * @param c
     * @param n
     * @return
     */
    private static int getTotalPointsOfHappiness(int[] a, int[] b, int[] c, int n) {
        int[] dpa = new int[n]; // SC: O(N)
        int[] dpb = new int[n]; // SC: O(N)
        int[] dpc = new int[n]; // SC: O(N)
        dpa[0] = a[0];
        dpb[0] = b[0];
        dpc[0] = c[0];
        // same activity cannot be done for two or more consecutive days
        dpa[1] = a[1] + Math.max(dpb[0], dpc[0]); // a[1] + Math.max(b[0], c[0]);
        dpb[1] = b[1] + Math.max(dpa[0], dpc[0]); // b[1] + Math.max(a[0], c[0]);
        dpc[1] = c[1] + Math.max(dpa[0], dpb[0]); // c[1] + Math.max(a[0], b[0]);
        for (int i = 2; i < n; i++) { // TC: O(N)
            dpa[i] = a[i] + Math.max(dpb[i - 1], dpc[i - 1]);
            dpb[i] = b[i] + Math.max(dpa[i - 1], dpc[i - 1]);
            dpc[i] = c[i] + Math.max(dpa[i - 1], dpb[i - 1]);
        }
        return Math.max(dpa[n - 1], Math.max(dpb[n - 1], dpc[n - 1]));
    }
}
