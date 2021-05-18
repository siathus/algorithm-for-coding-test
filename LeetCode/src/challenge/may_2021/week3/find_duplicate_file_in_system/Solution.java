package challenge.may_2021.week3.find_duplicate_file_in_system;

import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < paths.length; i++) {
            String[] pathArray = paths[i].split(" ");
            String directory = pathArray[0];
            for (int j = 1; j < pathArray.length; j++) {
                String fileName = pathArray[j].split("\\(")[0];
                String content = pathArray[j].split("\\(")[1].split("\\)")[0];

                String absolutePath = directory + "/" + fileName;
                if (map.containsKey(content)) {
                    List<String> files = map.get(content);
                    files.add(absolutePath);
                } else {
                    List<String> files = new ArrayList<>();
                    files.add(absolutePath);
                    map.put(content, files);
                }
            }
        }

        List<List<String>> dup = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() == 1) continue;
            dup.add(list);
        }
        return dup;
    }
}
