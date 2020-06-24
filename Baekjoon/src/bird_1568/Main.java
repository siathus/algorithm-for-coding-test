package bird_1568;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int second = 0;

        int count = 1;

        while (true) {
            if (n == 0) {
                System.out.println(second);
                return;
            }
            if (n < count) {
                count = 1;
            }
            n = n - count;
            count++;
            second++;
        }
    }
}
