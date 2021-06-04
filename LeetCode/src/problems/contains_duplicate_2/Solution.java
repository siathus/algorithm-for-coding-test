package problems.contains_duplicate_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) return false;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                List<Integer> indexList = map.get(num);
                indexList.add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(num, indexList);
            }
        }

        for (List<Integer> list : map.values()) {
            for (int i = 1; i < list.size(); i++) {
                if (Math.abs(list.get(i) - list.get(i - 1)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}