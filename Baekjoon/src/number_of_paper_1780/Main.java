package number_of_paper_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 종이의 개수 (1780)
public class Main {

    private static int[][] paper;
    private static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] rows = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(rows[j]);
            }
        }
        divide(n, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    private static void divide(int n, int y, int x) {
        int num = paper[y][x];
        boolean isMatch = true;
        for (int i = y; i < (y + n); i++) {
            for (int j = x; j < (x + n); j++) {
                if (num != paper[i][j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch == false) break;
        }

        if (isMatch == true) {
            if (num == -1) count[0]++;
            else if (num == 0) count[1]++;
            else count[2]++;
        } else {
            n = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(n, (y + (n * i)), (x + (n * j)));
                }
            }
        }
    }
}
