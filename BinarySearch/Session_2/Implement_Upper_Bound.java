package BinarySearch.Session_2;

public class Implement_Upper_Bound {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 4, 6, 6, 7 };
        int x = 5;
        int n = 6;
        int upBound = upperBound(arr, x, n);
        System.out.println(upBound);
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
