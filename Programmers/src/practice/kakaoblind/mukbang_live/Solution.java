package practice.kakaoblind.mukbang_live;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT > 무지의 먹방 라이브 (42891)
class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> queue = new PriorityQueue<>();
        long len = food_times.length;
        long sum = 0;

        for (int i = 0; i < len; i++) {
            sum += food_times[i];
            queue.offer(new Food(i + 1, food_times[i]));
        }

        if (sum <= k) return -1;

        long total = 0;
        long previous = 0;
        while (total + ((queue.peek().getTime() - previous) * len) < k) {
            int current = queue.poll().getTime();
            total += (current - previous) * len;
            len--;
            previous = current;
        }

        List<Food> leftList = new ArrayList<>();
        while (!queue.isEmpty()) {
            leftList.add(queue.poll());
        }
        Collections.sort(leftList, Comparator.comparingInt(Food::getIndex));

        int index = leftList.get((int)((k - total) % len)).getIndex();

        return index;
    }

    class Food implements Comparable<Food> {
        private int index;
        private int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Food f) {
            return this.getTime() - f.getTime();
        }
    }
}