package practice.level2.h_index;

import java.util.ArrayList;
import java.util.Collections;

// 정렬 > H-Index
public class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> citationList = new ArrayList<>();
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            citationList.add(citations[i]);
        }
        Collections.sort(citationList, Collections.reverseOrder());

        int idx = 0;
        while (idx < citationList.size()) {
            if (citationList.get(idx) <= idx) {
                break;
            }
            idx++;
        }
        return idx;
    }
}
