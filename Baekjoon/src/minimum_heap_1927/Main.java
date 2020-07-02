package minimum_heap_1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(sc.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(x);
            }
        }
    }
}
