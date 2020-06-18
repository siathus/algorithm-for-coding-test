package practice.level1.dart;

import java.util.ArrayList;

public class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] resultArr = dartResult.toCharArray();

        int idx = 0;
        ArrayList<Double> setScore = new ArrayList<>();
        int y = -1;
        int shopFlag = 1;
        while (idx < resultArr.length) {
            double score = 0;
            double bonus = 0;
            String option = "";
            if (resultArr[idx] >= '0' && resultArr[idx] <= '9') {
                if (resultArr[idx + 1] == '0') {
                    score = 10;
                    idx = idx + 2;
                } else {
                    score = resultArr[idx++] - '0';
                }
            }
            if (resultArr[idx] == 'S' || resultArr[idx] == 'T' || resultArr[idx] == 'D') {
                if (resultArr[idx] == 'S') {
                    bonus = 1;
                } else if (resultArr[idx] == 'D') {
                    bonus = 2;
                } else {
                    bonus = 3;
                }
                idx++;
            }
            if (idx < resultArr.length) {
                if (resultArr[idx] == '*' || resultArr[idx] == '#') {
                    option = String.valueOf(resultArr[idx++]);
                }
            }
            double setSum = Math.pow(score, bonus);
            setScore.add(setSum);
            y++;
            if (option.equals("*")) {
                setScore.set(y, (setScore.get(y) * 2));
                if (setScore.size() != 1) {
                    setScore.set((y - 1), (setScore.get(y - 1) * 2));
                }
            } else if (option.equals("#")) {
                setScore.set(y, (setScore.get(y) * -1));
            }
        }
        for (double n : setScore) {
            System.out.println(n);
            answer = answer + (int) n;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("1D#2S*3S"));
    }
}
