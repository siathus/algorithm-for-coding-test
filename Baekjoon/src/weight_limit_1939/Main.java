package weight_limit_1939;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int n;
    private static int start;
    private static int end;
    private static ArrayList<Weight>[] bridge;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        bridge = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            bridge[i] = new ArrayList<>();
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            bridge[a].add(new Weight(b, c));
            bridge[b].add(new Weight(a, c));
            min = Math.min(min, c);
            max = Math.max(max, c);
        }
        start = sc.nextInt();
        end = sc.nextInt();

        int result = start;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (bfs(mid)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean bfs(int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < bridge[x].size(); i++) {
                if (visited[bridge[x].get(i).c] == false && bridge[x].get(i).w >= mid) {
                    visited[bridge[x].get(i).c] = true;
                    queue.add(bridge[x].get(i).c);
                }
            }
        }
        return visited[end];
    }

    public static class Weight {
        public int c;
        public int w;

        public Weight(int c, int w) {
            this.c = c;
            this.w = w;
        }
    }
}
