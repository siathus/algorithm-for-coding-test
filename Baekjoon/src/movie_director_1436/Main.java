package movie_director_1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        int num = 666;
        int result = 0;
        while (true) {
            if (count == n) {
                break;
            }
            String s = String.valueOf(num);
            if (s.contains("666")) {
                count++;
                result = Integer.parseInt(s);
            }
            num++;
        }
        System.out.println(result);
    }
}
