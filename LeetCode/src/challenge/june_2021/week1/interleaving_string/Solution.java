package challenge.june_2021.week1.interleaving_string;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int len = s3.length();
        if (s1.length() + s2.length() != len) return false;

        int firstIndex = 0, secondIndex = 0;
        boolean first = true;
        int i = 0;
        String s = "";

        while (i < s3.length()) {
            if (first) {
                if (firstIndex < s1.length() && s3.charAt(i) != s1.charAt(firstIndex)) {
                    first = false;
                } else {
                    firstIndex++;
                    i++;
                }
            } else {
                if (secondIndex < s2.length() &&s3.charAt(i) == s2.charAt(secondIndex)) {
                    s += s3.charAt(i);
                    secondIndex++;
                    i++;
                } else {
                    first = true;
                }
            }
        }
        System.out.println("s = " + s);

        return (s.equals(s2)) ? true : false;
    }
}