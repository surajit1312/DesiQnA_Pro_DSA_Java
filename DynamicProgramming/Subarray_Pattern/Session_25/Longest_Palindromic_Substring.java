package DynamicProgramming.Subarray_Pattern.Session_25;

public class Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String S = "aaaabbaa";
        String longestPalin = longestPalindrome(S);
        System.out.println(longestPalin);
    }

    /**
     * TC: O(N x N + 2 x N) ~ O(N x N)
     * SC: O(N)
     */
    private static String longestPalindrome(String S) {
        int n = S.length();
        int maxLength = 0;
        boolean[][] dp = new boolean[n][n]; // SC: O(N)
        String result = "";
        // palindrome substring of length 1
        for (int i = 0; i < n; i++) { // TC: O(N)
            dp[i][i] = true;
            if (maxLength < 1) {
                maxLength = 1;
                result = S.substring(i, i + 1);
            }
        }
        // palindrome substring of length 2
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            if (S.charAt(i) == S.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
            if (dp[i][i + 1] && maxLength < 2) {
                maxLength = 2;
                result = S.substring(i, i + 2);
            }
        }
        // palindrome substring of length 3 to n
        for (int length = 3; length <= n; length++) { // TC: O(N)
            for (int i = 0; i <= n - length; i++) { // TC: O(N)
                int j = i + length - 1;
                if (S.charAt(i) == S.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    result = S.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
