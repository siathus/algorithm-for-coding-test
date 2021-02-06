package practice.level3.best_album;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;

        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!map.containsKey(genre)) {
                Map<Integer, Integer> initialMap = new HashMap<>();
                initialMap.put(i, play);
                map.put(genre, initialMap);
                playMap.put(genre, play);
            } else {
                Map<Integer, Integer> currentGenreMap = map.get(genre);
                currentGenreMap.put(i, play);
                map.replace(genre, currentGenreMap);

                playMap.put(genre, (playMap.get(genre) + play));
            }
        }

        List<Map.Entry<String, Integer>> sortedPlayList = new LinkedList<>(playMap.entrySet());
        Collections.sort(sortedPlayList, Comparator.comparing(Map.Entry::getValue));
        Collections.reverse(sortedPlayList);
        LinkedHashMap<String, Integer> sortedPlayMap = new LinkedHashMap<>();
        for (Map.Entry entry : sortedPlayList) {
            System.out.printf("key : %s\tvalue : %d\n", entry.getKey(), entry.getValue());
            sortedPlayMap.put((String) entry.getKey(), (Integer) entry.getValue());
        }

        List<Integer> resultList = new ArrayList<>();

        for (String genre : sortedPlayMap.keySet()) {
            LinkedHashMap<Integer, Integer> sortedMap = sortMapByValue(map.get(genre));
            int size = 0;
            for (Integer num : sortedMap.keySet()) {
                size++;
                resultList.add(num);
                if (size == 2) {
                    break;
                }
            }
        }
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }

    private LinkedHashMap<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int result = o1.getValue().compareTo(o2.getValue());
                if (result == 0) {
                    return (o1.getKey().compareTo(o2.getKey())) * -1;
                }
                return result;
            }
        });
        Collections.reverse(entryList);

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry entry : entryList) {
            System.out.printf("key : %d\t Value : %d\n", entry.getKey(), entry.getValue());
            result.put((Integer) entry.getKey(), (Integer) entry.getValue());
        }

        return result;
    }
}
