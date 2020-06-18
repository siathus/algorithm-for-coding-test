package friend_network_4195;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static HashMap<String, String> parent;
    static HashMap<String, Integer> num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            parent = new HashMap<>();
            num = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String[] s = sc.nextLine().split(" ");
                String first = s[0];
                String second = s[1];

                if (!parent.containsKey(first)) {
                    parent.put(first, first);
                    num.put(first, 1);
                }
                if (!parent.containsKey(second)) {
                    parent.put(second, second);
                    num.put(second, 1);
                }

                union(first, second);

                System.out.println(num.get(find(first)));
            }
        }
    }

    private static void union(String first, String second) {
        first = find(first);
        second = find(second);

        if (!first.equals(second)) {
            parent.replace(parent.get(second), first);
            num.replace(parent.get(second), num.get(second) + 1);
        }
    }
    private static String find(String str) {
        if (str.equals(parent.get(str))) {
            return str;
        }
        String p = find(parent.get(str));
        parent.replace(parent.get(str), p);
        return parent.get(str);
    }
}
