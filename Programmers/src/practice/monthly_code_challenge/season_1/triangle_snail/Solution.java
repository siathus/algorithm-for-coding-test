package practice.monthly_code_challenge.season_1.triangle_snail;

// 월간 코드 챌린지 시즌 1 > 삼각 달팽이
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(6);
        for (int i = 0; i < solution1.length; i++) {
            System.out.println(solution1[i]);
        }
    }
    public int[] solution(int n) {
        int[][] snail = new int[n][];
        int totalNum = 0;
        for (int i = 0; i < n; i++) {
            snail[i] = new int[i + 1];
            totalNum = totalNum + (i + 1);
        }

        int num = 1;
        int iterCount = n;
        int heightIndex = -1, weightIndex = 0;

        while (iterCount > 0) {
            for (int i = 0; i < iterCount; i++) {
                heightIndex = heightIndex + 1;
                snail[heightIndex][weightIndex] = num;
                num++;
            }
            iterCount--;
            if (iterCount == 0) {
                break;
            }
            for (int i = 0; i < iterCount; i++) {
                weightIndex = weightIndex + 1;
                snail[heightIndex][weightIndex] = num;
                num++;
            }
            iterCount--;
            if (iterCount == 0) {
                break;
            }
            for (int i = 0; i < iterCount; i++) {
                heightIndex = heightIndex - 1;
                weightIndex = weightIndex - 1;
                snail[heightIndex][weightIndex] = num;
                num++;
            }
            iterCount--;
        }

        int[] answer = new int[totalNum];
        int answerIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[answerIndex] = snail[i][j];
                answerIndex++;
            }
        }
        return answer;
    }
}
