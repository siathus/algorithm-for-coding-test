package display_trophy_1668;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> trophys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            trophys.add(Integer.parseInt(sc.nextLine()));
        }
        int maxHeight = 0;
        int count = 0;
        for (int trophy : trophys) {
            if (trophy > maxHeight) {
                count++;
                maxHeight = trophy;
            }
        }

        System.out.println(count);
        maxHeight = 0;
        count = 0;
        Collections.reverse(trophys);
        for (int trophy : trophys) {
            if (trophy > maxHeight) {
                count++;
                maxHeight = trophy;
            }
        }
        System.out.println(count);
    }
}
