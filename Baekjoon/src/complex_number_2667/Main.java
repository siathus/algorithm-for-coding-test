package complex_number_2667;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 단지번호붙이기 (2667)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] complex = new int[n][n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < input.length(); j++) {
                complex[i][j] = input.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (complex[i][j] == 1) {
                    complex[i][j] = 0;
                    pq.offer(bfs(complex, i, j, n));
                }
            }
        }
        System.out.println(pq.size());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static int bfs(int[][] complex, int i, int j, int n) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        int count = 0;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int y = coordinate.getY();
            int x = coordinate.getX();
            count++;

            if (y - 1 >= 0 && complex[y - 1][x] == 1) {
                complex[y - 1][x] = 0;
                queue.offer(new Coordinate(y - 1, x));
            }
            if (x + 1 < n && complex[y][x + 1] == 1) {
                complex[y][x + 1] = 0;
                queue.offer(new Coordinate(y, x + 1));
            }
            if (y + 1 < n && complex[y + 1][x] == 1) {
                complex[y + 1][x] = 0;
                queue.offer(new Coordinate(y + 1, x));
            }
            if (x - 1 >= 0 && complex[y][x - 1] == 1) {
                complex[y][x - 1] = 0;
                queue.offer(new Coordinate(y, x - 1));
            }
        }
        return count;
    }

    private static class Coordinate {
        private int y;
        private int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
