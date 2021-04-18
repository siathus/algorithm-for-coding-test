package quadtree_1992;

import java.util.Scanner;

// 쿼드트리
public class Main {

    private static int[][] display;
    private static StringBuilder compactString = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        display = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < n; j++) {
                display[i][j] = temp.charAt(j) - '0';
            }
        }

        divide(n, 0, 0);
        System.out.println(compactString.toString());
    }

    private static void divide(int n, int y, int x) {
        boolean compactable = true;
        for (int i = y; i < (y + n); i++) {
            for (int j = x; j < (x + n); j++) {
                if (display[y][x] != display[i][j]) {
                    compactable = false;
                    break;
                }
            }
            if (compactable == false)
                break;
        }

        if (compactable == true) {
            compactString.append(display[y][x]);
        } else {
            compactString.append("(");
            n = n / 2;
            divide(n, y, x);
            divide(n, y, (x + n));
            divide(n, (y + n), x);
            divide(n, (y + n), (x + n));
            compactString.append(")");
        }
    }
}
