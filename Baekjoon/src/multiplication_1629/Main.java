package multiplication_1629;

import java.util.Scanner;

// 곱셈 (1629)
public class Main {

    private static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(pow(a, b));
    }

    /**
     * n이 짝수일 때 2^n = {2^(n/2) * 2^(n/2)}
     * n이 홀수일 때 2^n = {2^((n-1)/2) * 2^((n-1)/2) * 2}
     */
    private static long pow(long a, int b) {
        if (b == 0) return 1;

        long n = pow(a, b / 2);
        long val = n * n % c;

        if (b % 2 == 0) {
            return val;
        } else {
            return (a * val) % c;
        }
    }
}
