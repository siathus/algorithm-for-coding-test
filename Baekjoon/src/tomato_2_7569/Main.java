package tomato_2_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 토마토 (7569)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);
        int[][][] box = new int[h][n][m];
        int space = 0;
        int finished = 0;
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                input = reader.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(input[k]);
                    if (box[i][j][k] != -1) space++;
                    if (box[i][j][k] == 1) {
                        queue.offer(new Coordinate(i, j, k));
                        finished++;
                    }
                }
            }
        }
        int days = -1;
        while (!queue.isEmpty()) {
            days++;
            List<Coordinate> next = new ArrayList<>();
            while (!queue.isEmpty()) {
                Coordinate coordinate = queue.poll();
                int depth = coordinate.getDepth();
                int height = coordinate.getHeight();
                int width = coordinate.getWidth();

                if (depth - 1 >= 0 && box[depth - 1][height][width] == 0) {
                    next.add(new Coordinate(depth - 1, height, width));
                    box[depth - 1][height][width] = 1;
                    finished++;
                }
                if (depth + 1 < h && box[depth + 1][height][width] == 0) {
                    next.add(new Coordinate(depth + 1, height, width));
                    box[depth + 1][height][width] = 1;
                    finished++;
                }
                if (height - 1 >= 0 && box[depth][height - 1][width] == 0) {
                    next.add(new Coordinate(depth, height - 1, width));
                    box[depth][height - 1][width] = 1;
                    finished++;
                }
                if (height + 1 < n && box[depth][height + 1][width] == 0) {
                    next.add(new Coordinate(depth, height + 1, width));
                    box[depth][height + 1][width] = 1;
                    finished++;
                }
                if (width - 1 >= 0 && box[depth][height][width - 1] == 0) {
                    next.add(new Coordinate(depth, height, width - 1));
                    box[depth][height][width - 1] = 1;
                    finished++;
                }
                if (width + 1 < m && box[depth][height][width + 1] == 0) {
                    next.add(new Coordinate(depth, height, width + 1));
                    box[depth][height][width + 1] = 1;
                    finished++;
                }
            }
            for (Coordinate nextCoordinate : next) {
                queue.offer(nextCoordinate);
            }
        }
        if (space != finished) System.out.println(-1);
        else System.out.println(days);
    }

    private static class Coordinate {
        private int depth;
        private int height;
        private int width;

        public Coordinate(int depth, int height, int width) {
            this.depth = depth;
            this.height = height;
            this.width = width;
        }

        public int getDepth() {
            return depth;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "depth=" + depth +
                    ", height=" + height +
                    ", width=" + width +
                    '}';
        }
    }
}
