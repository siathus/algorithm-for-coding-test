package install_router_2110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nc = reader.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int c = Integer.parseInt(nc[1]);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int start, end;

        Collections.sort(list);

        start = list.get(1) - list.get(0);
        end = list.get(n - 1) - list.get(0);
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int val = list.get(0);
            int count = 1;
            for (int i = 1; i < n; i++) {
                int cur = list.get(i);
                if (cur - mid >= val) {
                    val = cur;
                    count++;
                }
            }
            if (count >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
