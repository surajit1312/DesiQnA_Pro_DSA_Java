package BinarySearch.Session_12;

public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        int insertPosition = searchInsert(nums, target);
        System.out.println(insertPosition);
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int pos = Integer.MAX_VALUE;
        if (nums[0] > target) {
            return 0;
        }
        if (nums[n - 1] < target) {
            return n;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                pos = Math.min(pos, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pos;
    }
}
