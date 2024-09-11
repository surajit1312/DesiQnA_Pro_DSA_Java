package TwoPointers.Session_4;

import java.util.Arrays;

public class Squares_Of_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] sorted = sortedSquares(nums);
        System.out.println(Arrays.toString(sorted));
    }

    /**
     * Optimal Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                sorted[index--] = nums[left] * nums[left];
                left++;
            } else {
                sorted[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return sorted;
    }
}
