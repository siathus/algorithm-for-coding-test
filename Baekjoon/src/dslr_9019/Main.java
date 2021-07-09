package dslr_9019;

import java.util.*;

// DSLR (9019)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        StringBuilder output = new StringBuilder();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            String[] command = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();

            Arrays.fill(command, "");

            queue.offer(a);
            visited[a] = true;

            while (true) {
                int n = queue.poll();
                String c = command[n];

                if (n == b) break;

                int d = (n * 2 > 9999) ? (n * 2) % 10000 : n * 2;
                int s = (n == 0) ? 9999 : n - 1;
                int l = ((n % 1000) * 10) + (n / 1000);
                int r = ((n % 10) * 1000) + (n / 10);

                if (visited[d] == false) {
                    visited[d] = true;
                    command[d] = c + "D";
                    queue.offer(d);
                }
                if (visited[s] == false) {
                    visited[s] = true;
                    command[s] = c + "S";
                    queue.offer(s);
                }
                if (visited[l] == false) {
                    visited[l] = true;
                    command[l] = c + "L";
                    queue.offer(l);
                }
                if (visited[r] == false) {
                    visited[r] = true;
                    command[r] = c + "R";
                    queue.offer(r);
                }
            }
            output.append(command[b] + "\n");
        }
        System.out.println(output);
    }
}
