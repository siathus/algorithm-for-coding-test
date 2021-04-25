package challenge.april_2021.week2.verifying_an_alien_dictionary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        List<String> sortedWordList = Arrays.stream(words)
                .sorted((s1, s2) -> {
                    int s1Len = s1.length();
                    int s2Len = s2.length();
                    int s1Index = 0, s2Index = 0;
                    while (s1Index < s1Len && s2Index < s2Len) {
                        int s1OrderIndex = 0, s2OrderIndex = 0;
                        for (int i = 0; i < order.length(); i++) {
                            if (order.charAt(i) == s1.charAt(s1Index)) {
                                s1OrderIndex = i;
                                break;
                            }
                        }
                        for (int i = 0; i < order.length(); i++) {
                            if (order.charAt(i) == s2.charAt(s2Index)) {
                                s2OrderIndex = i;
                                break;
                            }
                        }
                        if (s1OrderIndex == s2OrderIndex) {
                            s1Index++;
                            s2Index++;
                        } else {
                            return s1OrderIndex - s2OrderIndex;
                        }
                    }
                    if (s1Len != s2Len) return s1Len - s2Len;
                    return 0;
                }).collect(Collectors.toList());
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(sortedWordList.get(i))) {
                return false;
            }
        }
        return true;
    }
}