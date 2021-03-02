package practice.level2.carpet;

// 완전탐색 > 카펫
public class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int width, height;

        for (height = 3; height <= (sum / 2); height++) {
            if (sum % height == 0) {
                width = sum / height;
                int currentBrown = (width * 2) + ((height - 2) * 2);
                int currentYellow = sum - currentBrown;
                if (currentBrown == brown && currentYellow == yellow) {
                    return new int[] {width, height};
                }
            }
        }
        int[] answer = {};
        return answer;
    }
}
