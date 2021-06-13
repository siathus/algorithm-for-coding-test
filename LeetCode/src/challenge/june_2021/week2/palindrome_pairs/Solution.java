package challenge.june_2021.week2.palindrome_pairs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = new String[] {"a",""};
        List<List<Integer>> a = s.palindromePairs(words);
        a.stream().forEach(l -> l.stream().forEach(System.out::println));
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        int len = words.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                String word = words[i] + words[j];
                int left, right;
                if (word.length() % 2 == 0) {
                    right = word.length() / 2;
                    left = right - 1;
                } else {
                    left = word.length() / 2;
                    right = left;
                }
                boolean isValid = true;
                while (left >= 0 && right < word.length()) {
                    if (word.charAt(left) != word.charAt(right)) {
                        isValid = false;
                        break;
                    }
                    left--;
                    right++;
                }
                if (isValid) {
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("word = " + word);
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
