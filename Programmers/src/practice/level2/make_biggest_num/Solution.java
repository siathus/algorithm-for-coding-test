package practice.level2.make_biggest_num;

// 탐욕법 > 큰 수 만들기
public class Solution {
    public String solution(String number, int k) {
        String answer = "";

        for (int i = 0, idx = -1; i < number.length() - k; i++) {
            char max = 0;
            for (int j = idx + 1; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    idx = j;
                    max = number.charAt(j);
                }
            }
            answer = answer + max;
        }
        return answer;
    }
}
