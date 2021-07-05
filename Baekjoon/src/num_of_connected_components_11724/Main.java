package num_of_connected_components_11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 연결 요소의 개수 (11724)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n +1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            count++;
            visited[i] = true;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (visited[j] == false && graph[current][j] == 1) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
