package challenge.april_2021.week2.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<String> combinations = new ArrayList<>();
    private String digits;
    private String[][] letters;

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return combinations;
        }
        this.digits = digits;

        letters = new String[10][];
        char letter = 'a';
        for (int i = 2; i <= 9; i++) {
            if (i == 7 || i == 9) {
                letters[i] = new String[4];
            } else {
                letters[i] = new String[3];
            }
            Arrays.fill(letters[i], "");
            for (int j = 0; j < letters[i].length; j++) {
                letters[i][j] += String.valueOf(letter++);
            }
        }
        dfs(0, "");
        return combinations;
    }

    private void dfs(int index, String path) {
        if (digits.length() == path.length()) {
            combinations.add(path);
            return;
        }

        int k = digits.charAt(index) - '0';
        for (int i = 0; i < letters[k].length; i++) {
            dfs(index + 1, path + letters[k][i]);
        }
    }
}
