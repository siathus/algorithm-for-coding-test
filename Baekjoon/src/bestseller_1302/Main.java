package bestseller_1302;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String book = sc.nextLine();
            if (map.containsKey(book)) {
                map.replace(book, map.get(book) + 1);
            } else {
                map.putIfAbsent(book, 1);
            }
        }
        int max = 0;
        String ans = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (max < value) {
                max = value;
                ans = key;
            }
        }

        System.out.println(ans);
    }
}
