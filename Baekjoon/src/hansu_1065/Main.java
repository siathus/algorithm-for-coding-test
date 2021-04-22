package hansu_1065;

import java.util.Scanner;

// 한수 (1065)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isHansu(i)) count++;
        }
        System.out.println(count);
    }

    private static boolean isHansu(int n) {
        if (n < 10) return true;

        char[] numbers = String.valueOf(n).toCharArray();

        int beforeDifference = numbers[0] - numbers[1];
        for (int i = 1; i < numbers.length - 1; i++) {
            int currentDifference = numbers[i] - numbers[i + 1];
            if (beforeDifference != currentDifference) return false;
        }
        return true;
    }
}
