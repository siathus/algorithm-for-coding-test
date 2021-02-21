package practice.level3.disk_controller;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> queue = new PriorityQueue<>();

        int totalTime = 0;
        int endTime = 0;
        int count = 0;
        int idx = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= endTime) {
                queue.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if (queue.isEmpty()) {
                endTime = jobs[idx][0];
            } else {
                Job job = queue.poll();
                totalTime = totalTime + job.workingTime + endTime - job.requestTime;
                endTime = endTime + job.workingTime;
                count++;
            }
        }
        return totalTime / jobs.length;
    }

    class Job implements Comparable<Job> {
        int requestTime;
        int workingTime;

        public Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.workingTime - o.workingTime;
        }
    }
}
