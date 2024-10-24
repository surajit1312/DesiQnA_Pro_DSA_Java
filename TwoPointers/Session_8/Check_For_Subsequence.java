package TwoPointers.Session_8;

import java.util.Scanner;

/**
 * Check_For_Subsequence
 */
public class Check_For_Subsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        String b = scn.nextLine();
        boolean isValid = isSubsequence(a, b);
        System.out.println(isValid);
        scn.close();
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static boolean isSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        int p = 0; // pointer for String a
        int q = 0; // pointer for String b
        while (p < m && q < n) {
            if (a.charAt(p) == b.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }
        if (q < n) {
            return false;
        }
        return true;
    }
}