package challenge.may_2021.week1.prefix_and_suffix_search;

import java.util.HashMap;
import java.util.Map;

class WordFilter {

    private Map<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                for (int k = 0; k <= words[i].length(); k++) {
                    String word = words[i];
                    String key = word.substring(0, j) + "#" + word.substring(word.length() - k);
                    map.put(key, i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        if (map.containsKey(prefix + "#" + suffix)) {
            return map.get(prefix + "#" + suffix);
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */