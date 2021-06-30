package hide_and_seek_1697;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질 (1697)
public class Main {

    private final static int LIMIT = 100_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] count = new int[LIMIT + 1];
        Arrays.fill(count, LIMIT);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        count[n] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int c = count[x] + 1;

            if (x - 1 >= 0 && count[x - 1] > c) {
                queue.offer(x - 1);
                count[x - 1] = c;
            }
            if (x + 1 <= LIMIT && count[x + 1] > c) {
                queue.offer(x + 1);
                count[x + 1] = c;
            }
            if (x * 2 <= LIMIT && count[x * 2] > c) {
                queue.offer(x * 2);
                count[x * 2] = c;
            }
        }

        System.out.println(count[k]);
    }
}
