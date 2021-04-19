package womens_chairman_2775;

import java.util.Scanner;

// 부녀회장이 될테야 (2775)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[][] building = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            building[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                int k = j;
                while(k >= 1) {
                    building[i][j] += building[i - 1][k];
                    k--;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(building[k][n]);
        }
    }
}
