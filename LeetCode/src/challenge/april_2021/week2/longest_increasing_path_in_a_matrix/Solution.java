package challenge.april_2021.week2.longest_increasing_path_in_a_matrix;

import java.util.Arrays;

class Solution {

    private int[][] dp;
    private int max = 1;
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                search(matrix, i, j);
            }
        }

        return max;
    }

    private void search(int[][] matrix, int m, int n) {
        if (m > 0 && matrix[m][n] > matrix[m - 1][n]) {
            if (dp[m][n] + 1 > dp[m - 1][n]) {
                dp[m - 1][n] = dp[m][n] + 1;
                max = Math.max(max, dp[m - 1][n]);
                search(matrix, m - 1, n);
            }
        }
        if (n + 1 < this.n && matrix[m][n] > matrix[m][n + 1]) {
            if (dp[m][n] + 1 > dp[m][n + 1]) {
                dp[m][n + 1] = dp[m][n] + 1;
                max = Math.max(max, dp[m][n + 1]);
                search(matrix, m, n + 1);
            }
        }
        if (m + 1 < this.m && matrix[m][n] > matrix[m + 1][n]) {
            if (dp[m][n] + 1 > dp[m + 1][n]) {
                dp[m + 1][n] = dp[m][n] + 1;
                max = Math.max(max, dp[m + 1][n]);
                search(matrix, m + 1, n);
            }
        }
        if (n > 0 && matrix[m][n] > matrix[m][n - 1]) {
            if (dp[m][n] + 1 > dp[m][n - 1]) {
                dp[m][n - 1] = dp[m][n] + 1;
                max = Math.max(max, dp[m][n - 1]);
                search(matrix, m, n - 1);
            }
        }
    }
}
