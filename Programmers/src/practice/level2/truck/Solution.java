package practice.level2.truck;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int length, int weight, int[] truck_weights) {
        int time = 0;
        Queue queue = new LinkedList();
        int currentWeight = 0;
        int idx = 0;

        while (true) {
            time++;
            if (queue.size() < length) {
                if (currentWeight + truck_weights[idx] <= weight) {
                    currentWeight = currentWeight + truck_weights[idx];
                    queue.add(truck_weights[idx]);
                    idx++;
                } else {
                    queue.add(0);
                }
            }

            if (queue.size() == length + 1) {
                currentWeight = currentWeight - (int)queue.poll();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution.solution(2, 10, truck_weights));
    }
}
