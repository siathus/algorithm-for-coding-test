package Z_1074;

import java.util.Scanner;

// Z (1074)
public class Main {

    private static int count = 0;
    private static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        divide((int)Math.pow(2, n), 0, 0);
    }

    private static void divide(int n, int y, int x) {
        if (y == r && x == c) {
            System.out.print(count);
            System.exit(0);
        }
        if (r < y + n && r >= y && c < x + n && c >= x) {
            n = n / 2;
            divide(n, y, x);
            divide(n, y, x + n);
            divide(n, y + n, x);
            divide(n, y + n, x + n);
        } else {
            count += (n * n);
        }
    }
}
