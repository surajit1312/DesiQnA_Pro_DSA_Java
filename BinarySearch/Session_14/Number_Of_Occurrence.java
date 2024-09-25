package BinarySearch.Session_14;

public class Number_Of_Occurrence {
    public static void main(String[] args) {
        int n = 7;
        int x = 2;
        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        int occurrences = count(arr, n, x);
        System.out.println(occurrences);
    }

    /**
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    private static int count(int[] arr, int n, int x) {
        // check if x is out of range of array 'arr'
        if (x < arr[0] || x > arr[n - 1]) {
            return 0;
        }
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                minIndex = Math.min(minIndex, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return 0;
        }
        low = 0;
        high = n - 1;
        int maxIndex = Integer.MIN_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                maxIndex = Math.max(maxIndex, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxIndex - minIndex + 1;
    }
}
