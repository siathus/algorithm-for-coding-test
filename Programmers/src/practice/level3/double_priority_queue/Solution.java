package practice.level3.double_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i].split(" ")[0];
            int operationNum = Integer.parseInt(operations[i].split(" ")[1]);

            if (operation.equals(("I"))) {
                queue.offer(operationNum);
                reverseQueue.offer(operationNum);
            } else {
                if (queue.isEmpty() && reverseQueue.isEmpty()) {
                    continue;
                }
                if (operationNum == 1) {
                    queue.remove(reverseQueue.remove());
                } else {
                    reverseQueue.remove(queue.remove());
                }
            }
        }

        if (queue.isEmpty() && reverseQueue.isEmpty()) {
            return new int[] {0, 0};
        }
        return new int[] {reverseQueue.poll(), queue.poll()};
    }
}
