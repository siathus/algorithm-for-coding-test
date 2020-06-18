package stack_progression_1874;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<String> print = new ArrayList<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            while (num <= arr[i]) {
                stack.push(num);
                num++;
                print.add("+");
            }
            if (stack.peek() == arr[i]) {
                print.add("-");
                stack.pop();
            } else {
                System.out.println("NO");
                return;
            }
        }

        for (String str : print) {
            System.out.println(str);
        }
    }
}