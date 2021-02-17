package practice.level2.printer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        int[] b = {1, 2, 3};

        a.addAll(Arrays.asList(b));

        System.out.println(a.pop());
    }
    public int solution(int[] priorities, int location) {
        LinkedList<Work> priorityList = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            priorityList.add(new Work(priorities[i], i));
        }

        int count = 0;

        while (true) {
            Work currentWork = priorityList.poll();

            Work maxWork = priorityList.stream().max(Comparator.comparing(Work::getPriority)).orElse(new Work(0, 0));
            if (currentWork.getPriority() >= maxWork.getPriority()) {
                count++;
                if (currentWork.getLocation() == location) {
                    return count;
                }
            } else {
                priorityList.addLast(currentWork);
            }
        }
    }

    class Work {
        private int priority;
        private int location;

        public Work(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public int getPriority() {
            return priority;
        }

        public int getLocation() {
            return location;
        }
    }
}
