package musical_scales_2920;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        boolean asc = true;
        boolean desc = true;
        for (int i = 1; i < 8; i++) {
            if (arr[i] > arr[i - 1]) {
                desc = false;
            } else {
                asc = false;
            }
        }
        if (asc){
            System.out.println("ascending");
        } else if (desc) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
