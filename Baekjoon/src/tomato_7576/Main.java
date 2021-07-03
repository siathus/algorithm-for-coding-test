package tomato_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 토마토 (7576)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        Queue<Coordinate> queue = new LinkedList<>();
        int[][] box = new int[n][m];

        // totalSpace = 토마토의 총 갯수, ripenTomatoes = 익은 토마토의 갯수
        int totalSpace = 0;
        int ripenTomatoes = 0;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if (box[i][j] != -1) totalSpace++;
                if (box[i][j] == 1) {
                    queue.offer(new Coordinate(i, j));
                    ripenTomatoes++;
                }
            }
        }

        int days = -1;
        while (!queue.isEmpty()) {
            days++;
            List<Coordinate> next = new ArrayList<>();

//            System.out.println("days = " + days);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(box[i][j] + " ");
//                }
//                System.out.println();
//            }

            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.poll();
                int y = coordinate.getY();
                int x = coordinate.getX();
                if (y - 1 >= 0 && box[y - 1][x] == 0) {
                    next.add(new Coordinate(y - 1, x));
                    box[y - 1][x] = 1;
                    ripenTomatoes++;
                }
                if (x + 1 < m && box[y][x + 1] == 0) {
                    next.add(new Coordinate(y, x + 1));
                    box[y][x + 1] = 1;
                    ripenTomatoes++;
                }
                if (y + 1 < n && box[y + 1][x] == 0) {
                    next.add(new Coordinate(y + 1, x));
                    box[y + 1][x] = 1;
                    ripenTomatoes++;
                }
                if (x - 1 >= 0 && box[y][x - 1] == 0) {
                    next.add(new Coordinate(y, x - 1));
                    box[y][x - 1] = 1;
                    ripenTomatoes++;
                }
            }
            for (Coordinate coordinate : next) {
                queue.offer(coordinate);
            }
        }

        if (ripenTomatoes == totalSpace) System.out.println(days);
        else System.out.println(-1);
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

        @Override
        public String toString() {
            return "y = " + y + "\tx = " + x;
        }
    }
}
