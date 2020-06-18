package practice.level1.hashad;

public class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int tmp = x;
        while (tmp > 0) {
            sum = sum + (tmp % 10);
            tmp = tmp / 10;
        }
        return (sum % x == 0) ? true : false;
    }
}
