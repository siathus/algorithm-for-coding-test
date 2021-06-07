package challenge.june_2021.week1.maximum_performance_of_a_team;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxPerformance(6, new int[]{2,10,3,1,5,8}, new int[]{5,4,3,9,7,2}, 3);
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(speed[i], efficiency[i]);
        }

        // 내림차순 정렬
        Arrays.sort(pairs, (o1, o2) -> o2.getEfficiency() - o1.getEfficiency());

        // 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long sum = 0, performance = 0;

        for (Pair pair : pairs) {
            int currentSpeed = pair.getSpeed();
            int currentEfficiency = pair.getEfficiency();

            if (pq.size() > k - 1) {
                sum -= pq.poll();
            }
            pq.offer(currentSpeed);
            sum += currentSpeed;
            performance = Math.max(performance, sum * currentEfficiency);
        }

        return (int)(performance % 1_000_000_007);
    }

    private class Pair {
        private int speed;
        private int efficiency;

        public Pair(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public int getSpeed() {
            return speed;
        }

        public int getEfficiency() {
            return efficiency;
        }
    }
}