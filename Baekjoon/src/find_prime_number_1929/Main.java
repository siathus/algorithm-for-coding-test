package find_prime_number_1929;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] nums = new boolean[n + 1];
        nums[1] = true;

        for (int i = 2; (i * i) <= n; i++) {
            if (nums[i]) continue;
            for (int j = (i * i); j <= n; j += i) {
                nums[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if (nums[i] == false) System.out.println(i);
        }
    }
}
