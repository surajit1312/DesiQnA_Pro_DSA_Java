package Hashing.Session_15;

import java.util.HashMap;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 2, 15, 3, 1, 4, 12, 10, 9, 8, 11, 16 };
        int longest = longestConsecutive(nums);
        System.out.println(longest);
    }

    /**
     * Optimal Approach
     * 
     * TC: O(2N) ~ O(N)
     * SC: O(2N) ~ O(N)
     * @param nums
     * @return
     */
    private static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hMap = new HashMap<Integer, Boolean>(); // SC: O(N)
        for (int num : nums) { // TC: O(N)
            hMap.put(num, true);
        }
        int longest = 0;
        HashMap<Integer, Boolean> checked = new HashMap<Integer, Boolean>(); // SC: O(N)
        for (int num : nums) { // TC: O(N)
            if (!checked.containsKey(num) && !hMap.containsKey(num - 1)) {
                // find the start of chain
                int start = num;
                int currentLength = 0;
                while (hMap.containsKey(start)) {
                    checked.put(start, true);
                    currentLength++;
                    start++;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }
}
