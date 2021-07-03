package meeting_room_1931;

import java.util.*;

// 회의실 (1931)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Time> timeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            timeList.add(new Time(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(timeList, (o1, o2) -> {
            if (o1.getEnd() == o2.getEnd()) {
                return o1.getStart() - o2.getStart();
            }
            return o1.getEnd() - o2.getEnd();
        });

        int count = 0;
        int lastEndTime = 0;
        for (Time time : timeList) {
            if (lastEndTime <= time.getStart()) {
                count++;
                lastEndTime = time.getEnd();
            }
        }

        System.out.println(count);
    }

    private static class Time {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
