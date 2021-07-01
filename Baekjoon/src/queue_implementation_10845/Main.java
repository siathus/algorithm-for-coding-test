package queue_implementation_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 큐 (10845)
public class Main {
    private static int[] queue = new int[100000];
    private static int head = 0, tail = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.startsWith("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                System.out.println(pop());
            } else if (command.equals("size")) {
                System.out.println(size());
            } else if (command.equals("front")) {
                System.out.println(front());
            } else if (command.equals("back")) {
                System.out.println(back());
            } else if (command.equals("empty")) {
                System.out.println(empty());
            }
        }
    }

    private static void push(int num) {
        queue[++tail] = num;
    }

    private static int pop() {
        if (empty() == 1) return -1;
        int num = queue[head++];
        if (head > tail) {
            head = 0;
            tail = -1;
        }
        return num;
    }

    private static int empty() {
        return tail == -1 ? 1 : 0;
    }

    private static int size() {
        return tail - head + 1;
    }

    private static int front() {
        if (empty() == 1) return -1;
        return queue[head];
    }

    private static int back() {
        if (empty() == 1) return -1;
        return queue[tail];
    }
}
