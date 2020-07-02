package card_sorting_1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(reader.readLine()));
        }
//
//        if (queue.size() == 1) {
//            System.out.println(queue.poll());
//            return;
//        }
        int result = 0;
        while (queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();
            int sum = a + b;
            result = result + sum;
            queue.add(sum);
        }
        System.out.println(result);
    }
}
