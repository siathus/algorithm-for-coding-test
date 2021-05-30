package challenge.may_2021.week4.evaluate_reverse_polish_notation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operations = new ArrayList<>();

        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        for (String token : tokens) {
            if (operations.contains(token)) {
                int second = stack.pop();
                int first = stack.pop();
                int result = 0;

                switch (token) {
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}