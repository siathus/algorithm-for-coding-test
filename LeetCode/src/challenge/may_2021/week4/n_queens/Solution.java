package challenge.may_2021.week4.n_queens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solveNQueens(4);
    }
    private List<List<String>> result = new ArrayList<>();
    private int[] coordinate = new int[] {-1, 0, 1};

    public List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];

        solve(map, 0);

        return result;
    }

    private void solve(int[][] map, int k) {
        int len = map.length;
        if (k == len) {
            createBoard(map);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (isValid(map, k, i)) {
                map[k][i] = 1;
                solve(map, k + 1);
                map[k][i] = 0;
            }
        }
    }

    private void createBoard(int[][] map) {
        int len = map.length;
        List<String> solved = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String row = "";
            for (int j = 0; j < len; j++) {
                if (map[i][j] == 0) row += ".";
                else row += "Q";
            }
            solved.add(row);
        }
        solved.stream().forEach(System.out::println);
        result.add(solved);
    }

    private boolean isValid(int[][] map, int y, int x) {
        int len = map.length;

        for (int j = 0; j < coordinate.length; j++) {
            int tempY = y;
            int tempX = x;
            while (tempY >= 0 && tempX >= 0 && tempX < len) {
                if (map[tempY][tempX] == 1) return false;
                tempY--;
                tempX += coordinate[j];
            }
        }

        return true;
    }
}