package word_study_1157;

import java.util.Scanner;

// 단어 공부 (1157)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str.toUpperCase();

        char[] words = str.toCharArray();
        int[] count = new int[26];

        for (char word : words) {
            count[(word - 'A')]++;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (i == maxIndex) continue;

            if (count[i] == max) {
                System.out.println("?");
                return;
            }
        }
        char ans = 'A';
        System.out.println(Character.toChars(ans + maxIndex));
    }
}
