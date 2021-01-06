package run_function_9184;

import java.util.Scanner;

public class Main {

    private static int[][][] dp = new int[51][51][51];

    public static void main(String[] args) {
        dp[0][0][0] = 1;
        Scanner sc = new Scanner(System.in);
        int a, b, c;

        while (true) {
            String[] input = sc.nextLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] != 0 ? dp[20][20][20] : w(20, 20, 20);
        } else if (a < b && b < c) {
            dp[a][b][c - 1] = dp[a][b][c - 1] == 0 ? w(a, b, c - 1) : dp[a][b][c - 1];
            dp[a][b - 1][c - 1] = dp[a][b - 1][c - 1] == 0 ? w(a, b - 1, c - 1) : dp[a][b - 1][c - 1];
            dp[a][b - 1][c] = dp[a][b - 1][c] == 0 ? w(a, b - 1, c) : dp[a][b - 1][c];
            return dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
        } else {
            dp[a - 1][b][c] = dp[a - 1][b][c] == 0 ? w(a - 1, b, c) : dp[a - 1][b][c];
            dp[a - 1][b - 1][c] = dp[a - 1][b - 1][c] == 0 ? w(a - 1, b - 1, c) : dp[a - 1][b - 1][c];
            dp[a - 1][b][c - 1] = dp[a - 1][b][c - 1] == 0 ? w(a - 1, b, c - 1) : dp[a - 1][b][c - 1];
            dp[a - 1][b - 1][c - 1] = dp[a - 1][b - 1][c - 1] == 0 ? w(a - 1, b - 1, c - 1) : dp[a - 1][b - 1][c - 1];
            return dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];
        }
    }
}
