package practice.level2.one_two_four;

// 연습문제 > 124 나라의 숫자
public class Solution {
    public String solution(int n) {
        String ans = "";
        String[] numbers = {"4", "1", "2"};

        while (n > 0) {
            ans = numbers[n % 3] + ans;
            n = n / 3;
            if (n % 3 == 0) {
                n = n - 1;
            }
        }
        return ans;
    }
}
