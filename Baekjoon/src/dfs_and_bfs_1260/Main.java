package dfs_and_bfs_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS (1026)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(v, visited, graph);
        System.out.println();

        visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        bfs(visited, graph, queue);
    }

    private static void dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= graph.length - 1; i++) {
            if (i == v) continue;
            if (graph[v][i] == 1 && visited[i] == false) {
                dfs(i, visited, graph);
            }
        }
    }

    private static void bfs(boolean[] visited, int[][] graph, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i = 1; i <= graph.length - 1; i++) {
                if (i == v) continue;
                if (graph[v][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
