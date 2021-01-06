package continuous_sum_1912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n];

        // 첫 번째 숫자는 그대로 받기
        dp[0] = sc.nextInt();

        int c;
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            c = sc.nextInt();
            dp[i] = c > (c + dp[i - 1]) ? c : (c + dp[i - 1]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
