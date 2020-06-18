package key_logger_5397;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] input = new String[n];

        /* 커서의 위치를 스택 두 개 사이로 가정한다.
         * 문자 추가 : 왼쪽 스택에 문자 삽입
         * "-" : 왼쪽 스택에서 문자 삭제
         * "<" : 커서가 왼쪽으로 움직임 --> 왼쪽 스택의 문자를 오른쪽 스택으로 이동
         * ">" : 커서가 오른쪽으로 움직임 --> 오른쪽 스택의 문자를 왼쪽 스택으로 이동
        */
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();

            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            char[] str = input[i].toCharArray();

            for (int j = 0; j < str.length; j++) {
                char s = str[j];
                switch (s) {
                    case '-':
                        if (!leftStack.isEmpty()) leftStack.pop();
                        break;
                    case '<':
                        if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                        break;
                    case '>':
                        if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                        break;
                    default:
                        leftStack.push(s);
                }
            }
            StringBuffer res = new StringBuffer();
            for (Character s : leftStack) {
                res.append(s);
            }
            while (!rightStack.isEmpty()) {
                res.append(rightStack.pop());
            }
            System.out.println(res);
        }
    }
}
