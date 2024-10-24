package TwoPointers.Session_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Count_Pairs_Sum_LessThanEqualsK
 */
public class Count_Pairs_Sum_LessThanEqualsK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int count = getCountPairSum(nums, n, k);
        System.out.println(count);
        scn.close();
    }

    private static int getCountPairSum(int[] nums, int n, int k) {
        Arrays.sort(nums);
        int count = 0;
        int sum = 0;
        for (int i = 0, j = n - 1; i < n; i++) {
            sum = nums[i] + nums[j];
            while (i != j && sum > k) {
                j--;
                sum = nums[i] + nums[j];
            }
            if (i == j) {
                break;
            }
            count += (j - i);
        }
        return count;
    }
}
