package fashion_king_9375;

import java.util.*;

// 패션왕 신혜빈 (9375)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<String, List<String>> map = new HashMap<>();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                String key = input[1];
                String value = input[0];
                map.computeIfAbsent(key, s -> new ArrayList<>()).add(value);
            }
            int sum = 1;
            for (String key : map.keySet()) {
                List<String> list = map.get(key);
                sum *= (list.size() + 1);
            }
            sum--;
            System.out.println(sum);
        }
    }
}
