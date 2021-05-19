package flip_1439;

import java.util.Scanner;

// 뒤집기 (1439)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[2];

        String s = sc.nextLine();

        int previous = s.charAt(0) - '0';
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - '0';
            if (current != previous) {
                count[previous]++;
            }
            previous = current;
        }
        count[previous]++;

        System.out.println((count[0] < count[1] ? count[0] : count[1]));
    }
}
