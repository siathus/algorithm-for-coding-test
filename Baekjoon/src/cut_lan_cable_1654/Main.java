package cut_lan_cable_1654;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        long start = 1;
        long end = list.get(list.size() - 1);
        int max = 0;
        while (start <= end) {
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            long mid = (start + end) / 2;
            if (check(list, mid, n)) {
                if (max < mid) max = (int)mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(max);
    }
    private static boolean check(List<Integer> list, long mid, int n) {
        int count = 0;
        if (mid <= 200) {
            System.out.println("mid = " + mid);
        }
        for (Integer num : list) {
            count += num / mid;
        }
        return (count >= n) ? true : false;
    }
}
