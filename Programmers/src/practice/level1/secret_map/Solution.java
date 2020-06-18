package practice.level1.secret_map;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int tmp = arr1[i];
            int[] tmparr = new int[n];
            int tmpIdx = n - 1;
            while (tmp != 0) {
                if (tmp % 2 == 1) {
                    tmparr[tmpIdx] = 1;
                } else {
                    tmparr[tmpIdx] = 0;
                }
                tmpIdx--;
                tmp = tmp / 2;
            }
            int[] tmparr2 = new int[n];
            tmp = arr2[i];
            tmpIdx = n - 1;
            while (tmp != 0) {
                if (tmp % 2 == 1) {
                    tmparr2[tmpIdx] = 1;
                } else {
                    tmparr2[tmpIdx] = 0;
                }
                tmpIdx--;
                tmp = tmp / 2;
            }
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                if (tmparr[j] == 1 || tmparr2[j] == 1) {
                    answer[i] = answer[i] + "#";
                } else {
                    answer[i] = answer[i] + " ";
                }
            }
        }

        return answer;
    }
}
