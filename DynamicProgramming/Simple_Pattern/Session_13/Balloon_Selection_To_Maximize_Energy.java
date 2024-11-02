package DynamicProgramming.Simple_Pattern.Session_13;

import java.util.Scanner;

/**
 * TC: O(N)
 * SC: O(2N) ~ O(N)
 */
public class Balloon_Selection_To_Maximize_Energy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt(); // 2
        while (t-- > 0) {
            long b = scn.nextLong(); // 3 queries [N -2 N]
            long[] dpmax = new long[(int) b + 1];
            long[] dpmin = new long[(int) b + 1];
            dpmax[0] = 1;
            dpmin[0] = 1;
            scn.nextLine();
            for (int i = 1; i <= b; i++) {
                // looping through all 'b' queries
                String line = scn.nextLine();
                char ch = line.charAt(0);
                long num = 0;
                if (line.length() > 2) {
                    num = Long.parseLong(line.substring(2));
                }
                if (ch == '+') {
                    dpmax[i] = max(dpmax[i - 1] + num, dpmax[i - 1], dpmin[i - 1] + num);
                    dpmin[i] = min(dpmax[i - 1] + num, dpmax[i - 1], dpmin[i - 1] + num);
                } else if (ch == '-') {
                    dpmax[i] = max(dpmax[i - 1] - num, dpmax[i - 1], dpmin[i - 1] - num);
                    dpmin[i] = min(dpmax[i - 1] - num, dpmax[i - 1], dpmin[i - 1] - num);
                } else if (ch == '*') {
                    dpmax[i] = max(dpmax[i - 1] * num, dpmax[i - 1], dpmin[i - 1] * num);
                    dpmin[i] = min(dpmax[i - 1] * num, dpmax[i - 1], dpmin[i - 1] * num);
                } else if (ch == '/') {
                    dpmax[i] = max(dpmax[i - 1] / num, dpmax[i - 1], dpmin[i - 1] / num);
                    dpmin[i] = min(dpmax[i - 1] / num, dpmax[i - 1], dpmin[i - 1] / num);
                } else {
                    dpmax[i] = max(-1 * dpmax[i - 1], dpmax[i - 1], -1 * dpmin[i - 1]);
                    dpmin[i] = min(-1 * dpmax[i - 1], dpmax[i - 1], -1 * dpmin[i - 1]);
                }
            }
            System.out.println(dpmax[(int) b]);
        }
        scn.close();
    }

    private static long max(long a, long b, long c) {
        return Math.max(a, Math.max(b, c));
    }

    private static long min(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }
}
