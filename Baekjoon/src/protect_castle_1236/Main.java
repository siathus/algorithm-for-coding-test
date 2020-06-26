package protect_castle_1236;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[][] castle = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] width = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                castle[i][j] = width[j];
            }
        }
        int colCount = 0;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (castle[i][j].equals("X")) {
                    break;
                }
            }
            if (j == m) {
                colCount++;
            }
        }
        int rowCount = 0;
        for (int i = 0; i < m; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (castle[j][i].equals("X")) {
                    break;
                }
            }
            if (j == n) {
                rowCount++;
            }
        }
        System.out.println(Math.max(rowCount, colCount));
    }
}
