package printer_queue_1966;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> mArr = new ArrayList<>();
        ArrayList<Integer> lArr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> priorityArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mArr.add(sc.nextInt());
            lArr.add(sc.nextInt());

            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < mArr.get(i); j++) {
                tmp.add(sc.nextInt());
            }
            priorityArr.add(tmp);
        }

        for (int i = 0; i < n; i++) {
            int m = mArr.get(i);
            int idx = lArr.get(i);
            ArrayList<Integer> priority = priorityArr.get(i);
            int count = 0;
            while (true) {
                int peek = priority.get(0);
                if (peek >= Collections.max(priority)) {
                    count++;
                    priority.remove(0);
                    if (idx == 0) {
                        System.out.println(count);
                        break;
                    }
                    idx--;
                } else {
                    priority.add(peek);
                    priority.remove(0);
                    if (idx == 0) {
                        idx = priority.size() - 1;
                    } else {
                        idx--;
                    }
                }
            }
        }
    }
}
