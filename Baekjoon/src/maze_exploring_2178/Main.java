package maze_exploring_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 미로 탐색 (2178)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n + 1][m + 1];
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < input.length(); j++) {
                maze[i][j + 1] = input.charAt(j) - '0';
            }
        }
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(1, 1, 0));

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int y = coordinate.getY();
            int x = coordinate.getX();
            int count = coordinate.getCount() + 1;

            if (y == n && x == m) {
                if (count < min) {
                    min = count;
                    maze[n][m] = min;
                }
                continue;
            }

            if (y - 1 >= 1) {
                if (maze[y - 1][x] == 1 || maze[y - 1][x] > count) {
                    queue.offer(new Coordinate(y - 1, x, count));
                    maze[y - 1][x] = count;
                }
            }
            if (x + 1 <= m) {
                if (maze[y][x + 1] == 1 || maze[y][x + 1] > count) {
                    queue.offer(new Coordinate(y, x + 1, count));
                    maze[y][x + 1] = count;
                }
            }
            if (y + 1 <= n) {
                if (maze[y + 1][x] == 1 || maze[y + 1][x] > count) {
                    queue.offer(new Coordinate(y + 1, x, count));
                    maze[y + 1][x] = count;
                }
            }
            if (x - 1 >= 1) {
                if (maze[y][x - 1] == 1 || maze[y][x - 1] > count) {
                    queue.offer(new Coordinate(y, x - 1, count));
                    maze[y][x - 1] = count;
                }
            }
        }
        System.out.println(maze[n][m]);
    }

    private static class Coordinate {
        private int y;
        private int x;
        private int count;

        public Coordinate(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getCount() {
            return count;
        }
    }
}
