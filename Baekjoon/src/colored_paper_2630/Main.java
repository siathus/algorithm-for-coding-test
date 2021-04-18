package colored_paper_2630;

import java.util.Scanner;

// 색종이 만들기 (2630)
public class Main {

    private static int white;
    private static int blue;
    private static int[][] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        divide(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int n, int y, int x) {
        int color = paper[y][x];
        boolean notMatch = false;
        for (int i = y; i < (y + n); i++) {
            for (int j = x; j < (x + n); j++) {
                if (color != paper[i][j]) {
                    notMatch = true;
                    break;
                }
            }
            if (notMatch == true)
                break;
        }

        if (notMatch == true) {
            n = n / 2;
            divide(n, y, x);
            divide(n, y, (x + n));
            divide(n, (y + n), x);
            divide(n, (y + n), (x + n));
        } else {
            if (color == 1) {
                blue++;
            } else {
                white++;
            }
        }
    }
}
