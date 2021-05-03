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
            // 현재 탐색중인 수업의 기간이 데드라인을 넘기지 않으면 큐에 바로 추가
            if (totalTime + courses[i][0] <= courses[i][1]) {
                pq.offer(courses[i][0]);
                totalTime += courses[i][0];
            // 그렇지 않다면 기간이 가장 긴 수업(큐의 맨 앞)과 현재 수업을 스왑
            } else if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                totalTime += courses[i][0] - pq.poll();
                pq.offer(courses[i][0]);
            }
        }
        // 큐에 남은 갯수가 최대 갯수가 된다.
        return pq.size();
    }
}