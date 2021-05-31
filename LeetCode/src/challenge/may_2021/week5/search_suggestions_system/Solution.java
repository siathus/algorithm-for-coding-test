package challenge.may_2021.week5.search_suggestions_system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> productList =Arrays.stream(products)
                .sorted()
                .collect(Collectors.toList());
        List<List<String>> suggestionList = new ArrayList<>();
        String s = "";

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> suggestion = new ArrayList<>();
            s += searchWord.charAt(i);

            final String finalS = s;
            List<String> filteredList = productList.stream()
                    .filter(p -> p.startsWith(finalS))
                    .limit(3)
                    .collect(Collectors.toList());

            if (filteredList.size() == 0) {
                for (int j = i; j < searchWord.length(); j++) {
                    suggestionList.add(new ArrayList<>());
                }
                return suggestionList;
            }
            suggestion.addAll(filteredList);
            suggestionList.add(suggestion);
        }

        return suggestionList;
    }
}