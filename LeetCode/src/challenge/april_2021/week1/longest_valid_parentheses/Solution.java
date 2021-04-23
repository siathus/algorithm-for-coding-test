package challenge.april_2021.week1.longest_valid_parentheses;

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, (left * 2));
            } else if (right >= left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else {
                left++;
            }

            if (left == right) {
                max = Math.max(max, (left * 2));
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return max;
    }
}