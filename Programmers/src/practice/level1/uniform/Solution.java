package practice.level1.uniform;

import java.util.Arrays;

// 탐욕법 > 체육복
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];

        // 모두 한 벌씩 가지고 있도록 초기화
        Arrays.fill(students, 1);

        // 여벌 갯수 적용
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]]++;
        }

        // 도난당한 학생 적용
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]]--;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (i - 1 >= 1 && students[i - 1] == 2) {
                    students[i - 1] = 1;
                    students[i] = 1;
                    count++;
                } else if (i + 1 <= n && students[i + 1] == 2) {
                    students[i + 1] = 1;
                    students[i] = 1;
                    count++;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}
