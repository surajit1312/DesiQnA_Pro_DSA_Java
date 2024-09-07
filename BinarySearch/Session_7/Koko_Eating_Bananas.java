package BinarySearch.Session_7;

public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077,
                337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728,
                941802184 };
        int h = 823855818;

        int minSpeedBF = minEatingSpeedBruteForce(piles, h);
        System.out.println(minSpeedBF);

        int minSpeedOptimal = minEatingSpeedOptimal(piles, h);
        System.out.println(minSpeedOptimal);
    }

    /**
     * Optimal Solution
     * TC: O(Nlog(N))
     * SC: O(1)
     * 
     * @param piles
     * @param h
     * @return
     */
    private static int minEatingSpeedOptimal(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int it : piles) {
            high = Math.max(high, it);
        }
        int minSpeed = Integer.MAX_VALUE;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            long duration = minDuration(piles, mid);
            if (duration <= h) {
                minSpeed = Math.min(minSpeed, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minSpeed;
    }

    private static long minDuration(int[] piles, int mid) {
        long duration = 0L;
        for (int i = 0; i < piles.length; i++) { // TC: O(N)
            long current = piles[i] % mid == 0 ? piles[i] / mid : (piles[i] / mid) + 1;
            duration += current;
        }
        return duration;
    }

    /**
     * Brute-Force Solution
     * TC: O(N)
     * SC: O(1)
     * 
     * @param piles
     * @param h
     * @return
     */
    private static int minEatingSpeedBruteForce(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int it : piles) {
            high = Math.max(high, it);
        }
        for (int i = low; i <= high; i++) {
            long duration = 0L;
            for (int j = 0; j < piles.length; j++) {
                long current = piles[j] % i == 0 ? piles[j] / i : (piles[j] / i) + 1;
                duration += current;
            }
            if (duration <= h) {
                return i;
            }
        }
        return -1;
    }
}
