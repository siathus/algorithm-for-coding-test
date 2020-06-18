package practice.level1.remove_min;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (min > value) {
                min = value;
                minIdx = i;
            }
        }
        int ansIdx = 0;
        for (int i = 0; i < answer.length; i++) {
            if (i == minIdx) {
                continue;
            }
            answer[ansIdx++] = arr[i];
        }
        return answer;
    }
}
