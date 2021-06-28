package six_degrees_1389;

import java.util.Arrays;
import java.util.Scanner;

// 케빈 베이컨의 6단계 법칙 (1389)
public class Main {

    private final static int K = 100_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                graph[i][j] = K;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ansIndex = 0;
        for (int i = 1; i <= n; i++) {
            int sum = Arrays.stream(graph[i]).sum();
            if (sum < min) {
                min = sum;
                ansIndex = i;
            }
        }
        System.out.println(ansIndex);
    }
}
