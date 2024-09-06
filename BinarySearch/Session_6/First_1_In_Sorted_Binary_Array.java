package BinarySearch.Session_6;

public class First_1_In_Sorted_Binary_Array {
    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
        long index = firstIndex(arr);
        System.out.println(index);
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param arr
     * @return
     */
    public static long firstIndex(int arr[]) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                high = mid - 1;
                minIndex = Math.min(minIndex, mid);
            } else {
                low = mid + 1;
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
