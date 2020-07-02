package workbook_1766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] ab = reader.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            if (!map.containsKey(a)) {
                ArrayList<Integer> queue = new ArrayList<>();
                queue.add(b);
                map.put(a, queue);
            } else {
                ArrayList queue = map.get(a);
                queue.add(b);
                map.replace(a, queue);
            }
            indegree[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int key = queue.poll();
            result.add(key);
            ArrayList<Integer> list = map.get(key);
            if (list != null) {
                for (int k : list) {
                    indegree[k]--;
                    if (indegree[k] == 0) {
                        queue.add(k);
                    }
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
