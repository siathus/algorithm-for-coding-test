package find_num_1920;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashSet<Integer> a = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int m = sc.nextInt();

        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
        for (int i : b) {
            if (a.contains(i)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
