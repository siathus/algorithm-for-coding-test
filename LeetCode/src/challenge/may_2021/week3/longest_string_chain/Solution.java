package challenge.may_2021.week3.longest_string_chain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int max = 1;

        for (String word : words) {
            int presentLength = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder tmp = new StringBuilder(word);
                tmp.deleteCharAt(i);
                int previousLength = dp.getOrDefault(tmp.toString(), 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            max = Math.max(max, presentLength);
        }

        return max;
    }
}