package BinarySearch.Session_14;

public class Middle_Occurrence_Of_Element_In_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 2, 3, 4, 5, 6, 7 };
        int target = 2;
        int middleIndex = middleOccurrence(nums, target);
        System.out.println(middleIndex);
    }

    /**
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private static int middleOccurrence(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                minIndex = Math.min(minIndex, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        low = 0;
        high = n - 1;
        int maxIndex = Integer.MIN_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                maxIndex = Math.max(maxIndex, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (minIndex + maxIndex) / 2;
    }
}
