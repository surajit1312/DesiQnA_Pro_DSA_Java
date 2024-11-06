package DynamicProgramming.Subarray_Pattern.Session_24;

public class Count_Palindromic_Substrings {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int count = countSubstrings(s);
        System.out.println(count);
    }
    
    private static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[][] dpCount = new int[n][n];
        // for length 1 substring palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            dpCount[i][i] = 1;
        }
        // for length 2 substring palindrome
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            dpCount[i][i + 1] = dpCount[i][i] + dpCount[i + 1][i + 1] + (dp[i][i + 1] ? 1: 0);
        }
        // for length 3 and above till n substring palindrome
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
                dpCount[i][j] = dpCount[i][j - 1] + dpCount[i + 1][j] - dpCount[i + 1][j - 1] + (dp[i][j] ? 1 : 0);
            }
        }
        return dpCount[0][n - 1];
    }
}
