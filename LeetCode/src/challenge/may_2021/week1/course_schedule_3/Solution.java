package challenge.may_2021.week1.course_schedule_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // 데드라인 순으로 정렬
        Arrays.sort(courses, Comparator.comparingInt((o) -> o[1]));
        // 우선순위 큐의 정렬 순서를 내림차순으로 설정(가장 큰 값이 가장 앞에 오도록)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int totalTime = 0;
        for (int i = 0; i < courses.length; i++) {
            //
            if (totalTime + courses[i][0] <= courses[i][1]) {
                pq.offer(courses[i][0]);
                totalTime += courses[i][0];
            } else if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                totalTime += courses[i][0] - pq.poll();
                pq.offer(courses[i][0]);
            }
        }
        return pq.size();
    }
}