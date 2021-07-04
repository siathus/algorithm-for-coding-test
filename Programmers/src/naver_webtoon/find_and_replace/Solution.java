package naver_webtoon.find_and_replace;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("a", "x");
    }
    public int solution(String s, String t) {
        int count = 0;
        while (s.contains(t)) {
            s = s.replaceFirst(t, "");
            count++;
            System.out.println("s = " + s);
        }

        System.out.println("count = " + count);
        return count;
    }
}
