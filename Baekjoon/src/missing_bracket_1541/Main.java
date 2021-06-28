package missing_bracket_1541;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 잃어버린 괄호 (1541)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<String> arr = new ArrayList<>();

        int i = 0;
        String s = "";
        while (true) {
            char c = input.charAt(i);
            if (i == input.length() - 1) {
                arr.add(s + c);
                break;
            }
            if (c == '+' || c == '-') {
                arr.add(s);
                s = "";
                arr.add(String.valueOf(c));
            } else {
                s += c;
            }
            i++;
        }

        i = 1;
        int ans = Integer.parseInt(arr.get(0));
        while (i < arr.size()) {
            if (arr.get(i).equals("-")) {
                int sum = Integer.parseInt(arr.get(i + 1));
                int j = i + 2;
                while (j < arr.size()) {
                    if (arr.get(j).equals("+")) {
                        sum += Integer.parseInt(arr.get(j + 1));
                    } else {
                        break;
                    }
                    j += 2;
                }
                ans -= sum;
                i = j;
            } else {
                ans += Integer.parseInt(arr.get(i + 1));
                i += 2;
            }
        }
        System.out.println(ans);
    }
}
