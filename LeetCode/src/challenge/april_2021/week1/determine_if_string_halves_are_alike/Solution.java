package challenge.april_2021.week1.determine_if_string_halves_are_alike;

class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int len = s.length() / 2;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        String a = s.substring(0, len);
        String b = s.substring(len);

        int aCount = 0, bCount = 0;

        for (int i = 0; i < len; i++) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            for (char vowel : vowels) {
                if (aChar == vowel) aCount++;
                if (bChar == vowel) bCount++;
            }
        }
        if (aCount == bCount) return true;

        return false;
    }
}
