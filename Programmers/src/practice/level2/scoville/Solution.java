package practice.level2.scoville;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while (queue.size() >= 2) {
            count++;
            int aFood = queue.poll();
            int bFood = queue.poll();
            queue.offer(aFood + (bFood * 2));

            if (queue.peek() >= K) {
                return count;
            }
        }

        if (queue.size() == 1) {
            if (queue.poll() < K) {
                return -1;
            } else {
                return ++count;
            }
        }

        return -1;
    }
}
