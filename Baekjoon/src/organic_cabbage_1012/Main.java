package organic_cabbage_1012;

import java.util.Scanner;

// 유기농 배추 (1012)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] land = new int[n][m];
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                land[y][x] = 1;
            }
            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (land[y][x] == 1) {
                        count++;
                        dfs(land, y, x);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int[][] land, int y, int x) {
        if (land[y][x] != 1) return;

        int ylen = land.length;
        int xlen = land[0].length;

        land[y][x] = 2;

        if (y - 1 >= 0) dfs(land, y - 1, x);
        if (x + 1 < xlen) dfs(land, y, x + 1);
        if (y + 1 < ylen) dfs(land, y + 1, x);
        if (x - 1 >= 0) dfs(land, y, x - 1);
    }
}
