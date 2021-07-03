package worm_virus_2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 바이러스 (2606)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] network = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            network[x][y] = 1;
            network[y][x] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (visited[i] == false && network[current][i] == 1) {
                    visited[i] = true;
                    count++;
                    queue.offer(i);
                }
            }
        }
        System.out.println(count);
    }
}
