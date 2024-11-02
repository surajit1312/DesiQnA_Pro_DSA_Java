package DynamicProgramming.Simple_Pattern.Session_11;

import java.util.Scanner;

public class Minimum_Steps_To_Reduce_N_To_One {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n + 1];
		dp[1] = 0; // number of steps to make 1 as 1
		for (int i = 2; i <= n; i++) {
			int choice1 = 1 + dp[i - 1];
			int choice2 = Integer.MAX_VALUE;
			if (i % 2 == 0) {
				choice2 = 1 + dp[i / 2];
			}
			int choice3 = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				choice3 = 1 + dp[i / 3];
			}
			dp[i] = Math.min(choice1, Math.min(choice2, choice3));
		}
		System.out.println(dp[n]);
		scn.close();
	}
}
