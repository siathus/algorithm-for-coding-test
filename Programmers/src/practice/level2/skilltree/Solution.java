package practice.level2.skilltree;

import java.util.HashMap;

public class Solution {
    public int solution(String tmp, String[] skillTrees) {
        int answer = 0;
        String[] skill = tmp.split("");

        for (int i = 0; i < skillTrees.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < skill.length; j++) {
                if (skillTrees[i].contains(skill[j])) {
                    map.put(skill[j], skillTrees[i].indexOf(skill[j]));
                }
            }

            int before = 0;
            boolean flag = false;
            for (int j = 0; j < skill.length; j++) {
                if (!map.containsKey(skill[j])) {
                    continue;
                }
                int current = map.get(skill[j]);
                
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution.solution("CBD", s));
    }
}
