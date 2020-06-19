package Z_1074;

import java.util.Scanner;

public class Main {

    private static int count = 0;
    private static int r;
    private static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 1;
        int tmp = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        for (int i = 0; i < tmp; i++) {
            n = 2 * n;
        }
        recur(n, 0, 0);
    }

    private static void recur(int n, int y, int x) {
        if (n == 2) {
            if (y == r && x == c) {
                System.out.println(count);
                return;
            }
            count++;
            if (r == y && c == x + 1) {
                System.out.println(count);
                return;
            }
            count++;
            if (r == y + 1 && c == x) {
                System.out.println(count);
                return;
            }
            count++;
            if (r == y + 1 && c == x + 1) {
                System.out.println(count);
                return;
            }
            count++;
            return;
        }
        recur(n / 2, y, x);
        recur(n / 2, y, x + n / 2);
        recur(n / 2, y + n / 2, x);
        recur(n / 2, y + n / 2, x + n / 2);
    }
}
