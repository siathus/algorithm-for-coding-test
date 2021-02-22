package practice.level3.integer_triangle;

import java.util.Arrays;

// 코딩테스트 연습_동적계획법_정수삼각형
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution.solution(triangle));
    }
    public int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][len];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < len; i++) {
            // 맨 처음과 맨 끝은 비교 필요 x
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        Arrays.sort(dp[len - 1]);
        return dp[len - 1][len - 1];
    }
}
