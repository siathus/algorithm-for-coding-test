package stack_implementation_10828;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

// 스택 (10828)
public class Main {

    private static int[] stack = new int[10000];
    private static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.startsWith("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("top")) {
                System.out.println(top());
            } else if (command.equals("size")) {
                System.out.println(size());
            } else if (command.equals("pop")) {
                System.out.println(pop());
            } else if (command.equals("empty")) {
                System.out.println(empty());
            }
        }
    }

    private static void push(int num) {
        stack[++top] = num;
    }

    private static int empty() {
        return top == -1 ? 1 : 0;
    }

    private static int size() {
        return empty() == 1 ? 0 : top + 1;
    }

    private static int top() {
        if (empty() == 1) {
            return -1;
        }
        return stack[top];
    }

    private static int pop() {
        if (empty() == 1) {
            return -1;
        }
        return stack[top--];
    }
}

