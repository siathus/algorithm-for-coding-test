package practice.level1.crane;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length = board.length;

        Stack<Integer> bucket = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int order = moves[i] - 1;
            for (int j = 0; j < length; j++) {
                if (board[j][order] != 0) {
                    bucket.push(board[j][order]);
                    board[j][order] = 0;
                    break;
                }
            }
            if(bucket.size() >= 2) {
                int tmp = bucket.pop();
                if (tmp == bucket.peek()) {
                    bucket.pop();
                    answer = answer + 2;
                } else {
                    bucket.push(tmp);
                }
            }
        }
        return answer;
    }
}
