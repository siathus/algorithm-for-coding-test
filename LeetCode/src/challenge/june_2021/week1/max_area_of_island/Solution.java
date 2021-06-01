package challenge.june_2021.week1.max_area_of_island;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Coordinate> queue = new LinkedList<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    queue.offer(new Coordinate(i, j));
                    int area = 0;
                    while (!queue.isEmpty()) {
                        Coordinate coordinate = queue.poll();
                        int y = coordinate.getY();
                        int x = coordinate.getX();
                        area++;
                        if (y - 1 >= 0 && grid[y - 1][x] == 1) {
                            grid[y - 1][x] = 2;
                            queue.offer(new Coordinate(y - 1, x));
                        }
                        if (x + 1 < m && grid[y][x + 1] == 1) {
                            grid[y][x + 1] = 2;
                            queue.offer(new Coordinate(y, x + 1));
                        }
                        if (y + 1 < n && grid[y + 1][x] == 1) {
                            grid[y + 1][x] = 2;
                            queue.offer(new Coordinate(y + 1, x));
                        }
                        if (x - 1 >= 0 && grid[y][x - 1] == 1) {
                            grid[y][x - 1] = 2;
                            queue.offer(new Coordinate(y, x - 1));
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private class Coordinate {

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