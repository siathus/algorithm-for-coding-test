package remote_controller_1107;

import java.util.Scanner;

// 리모컨 (1107)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] isBroken = new boolean[10];

        for (int i = 0; i < m; i++) {
            isBroken[sc.nextInt()] = true;
        }

        // 초기값인 100부터 방향키만으로 n으로 도달하는 경우
        int min = Math.abs(n - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            // count() : i번 채널을 숫자 입력으로 이동할 수 있을 경우 눌러야 되는 버튼의 수 계산
            int len = count(i, isBroken);
            if (len != 0) {
                // i번 채널에서 n번 채널까지 눌러야 되는 방향키의 수 계산
                len = len + Math.abs(n - i);
                min = Math.min(min, len);
            }
        }
        System.out.println(min);
    }

    private static int count(int n, boolean[] isBroken) {
        if (n == 0) {
            if (isBroken[0]) return 0;
            else return 1;
        }
        int count = 0;
        while (n > 0) {
            if (isBroken[n % 10]) return 0;
            n = n / 10;
            count++;
        }
        return count;
    }
}
