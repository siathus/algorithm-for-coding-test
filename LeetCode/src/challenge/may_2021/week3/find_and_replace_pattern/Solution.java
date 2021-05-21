package challenge.may_2021.week3.find_and_replace_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> match = new ArrayList<>();
        Map<Character, Character> wordMap;
        Map<Character, Character> patternMap;

        for (String word : words) {
            wordMap = new HashMap<>();
            patternMap = new HashMap<>();
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                char patternAlphabet = pattern.charAt(i);
                char wordAlphabet = word.charAt(i);

                if (!wordMap.containsKey(wordAlphabet))
                    wordMap.put(wordAlphabet, patternAlphabet);
                if (!patternMap.containsKey(patternAlphabet))
                    patternMap.put(patternAlphabet, wordAlphabet);

                if (wordMap.get(wordAlphabet) != patternAlphabet
                        || patternMap.get(patternAlphabet) != wordAlphabet) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) match.add(word);
        }
        return match;
    }
}