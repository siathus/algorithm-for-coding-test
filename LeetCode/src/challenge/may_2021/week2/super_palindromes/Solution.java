package challenge.may_2021.week2.super_palindromes;

class Solution {
    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int count = 0;

        // 자릿수가 홀수일 때
        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            for (int j = s.length() - 2; j >= 0; j--) {
                s = s + s.charAt(j);
            }
            long palindrome = Long.parseLong(s);
            palindrome *= palindrome;
            if (palindrome > r)
                break;
            if (palindrome >= l && isSuperpalindrome(palindrome))
                count++;
        }

        // 자릿수가 짝수일 때
        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                s = s + s.charAt(j);
            }
            long palindrome = Long.parseLong(s);
            palindrome *= palindrome;
            if (palindrome > r)
                break;
            if (palindrome >= l && isSuperpalindrome(palindrome))
                count++;
        }
        return count;
    }

    private boolean isSuperpalindrome(long p) {
        String s = Long.toString(p);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}