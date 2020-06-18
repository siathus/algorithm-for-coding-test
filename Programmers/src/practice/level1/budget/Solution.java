package practice.level1.budget;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int ans = 0;
        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget = budget - d[i];
                ans++;
            }
        }
        return ans;
    }
}
