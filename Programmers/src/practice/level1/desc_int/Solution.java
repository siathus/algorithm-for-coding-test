package practice.level1.desc_int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        List list = Arrays.asList(Long.toString(n).split(""));

        Collections.sort(list);
        Collections.reverse(list);
        String tmp = "";
        for (int i = 0; i < list.size(); i++) {
            tmp = tmp + list.get(i);
        }

        answer = Long.parseLong(tmp);

        return answer;
    }
}
