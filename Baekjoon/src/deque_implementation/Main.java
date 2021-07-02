package deque_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 덱 (10866)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.startsWith("push_front")) {
                deque.addFirst(Integer.parseInt(command.split(" ")[1]));
            } else if (command.startsWith("push_back")) {
                deque.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if (command.equals("size")) {
                System.out.println(deque.size());
            } else if (command.equals("empty")) {
                System.out.println(deque.isEmpty() ? 1 : 0);
            } else if (command.equals("front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            } else if (command.equals("back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
        }
    }
}
