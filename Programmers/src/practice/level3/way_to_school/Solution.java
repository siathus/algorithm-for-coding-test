package practice.level3.way_to_school;

// 코딩테스트 연습_동적계획법_등굣길
public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int[][] map = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            int puddleM = puddles[i][0];
            int puddleN = puddles[i][1];
            map[puddleN][puddleM] = 1;
        }

        int count = 1;
        // 첫 번째 행은 오른쪽으로밖에 이동하지 못함
        for (int i = 2; i <= m; i++) {
            // 첫 번째 행에 웅덩이가 있으면 그 뒤는 진입 불가
            if (map[1][i] == 1) {
                count = 0;
            }
            dp[1][i] = count;
        }

        // 첫 번째 열은 아래로밖에 이동하지 못함
        count = 1;
        for (int i = 2; i <= n; i++) {
            // 첫 번째 열에 웅덩이가 있으면 그 뒤는 진입 불가
            if (map[i][1] == 1) {
                count = 0;
            }
            dp[i][1] = count;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        return dp[n][m];
    }
}
