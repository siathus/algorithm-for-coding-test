package practice.level2.make_biggest_num;

// 탐욕법 > 큰 수 만들기
public class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int count = number.length() - k;
        int left = 0;
        int right = number.length() - count;
        int max;

        while (count > 0) {
            max = -1;
            System.out.printf("left : %d\tright : %d\n", left, right);
            for (int i = left; i <= right; i++) {
                int currentNumber = number.charAt(i) - '0';
                if (currentNumber == 9) {
                    left = i;
                    max = currentNumber;
                    break;
                }
                if (max < currentNumber) {
                    left = i;
                    max = currentNumber;
                }
            }
            answer.append(max);
            left++;
            count--;
            right = number.length() - count;
        }
        return answer.toString();
    }
}
