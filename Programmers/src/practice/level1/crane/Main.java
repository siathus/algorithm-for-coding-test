package practice.level1.crane;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}

        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution.solution(board, moves));

    }
}
