package josepus_0_11866;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 요세푸스 문제 0 (11866)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        String ans = "<";
        int removeIndex = 0;

        for (int i = 0; i < n - 1; i++) {
            removeIndex = (removeIndex + k - 1) % list.size();
            ans += list.get(removeIndex) + ", ";
            list.remove(removeIndex);
        }
        ans += list.get(0) + ">";
        System.out.println(ans);
    }
}
