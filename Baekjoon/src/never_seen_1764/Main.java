package never_seen_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 듣보잡 (1764)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>();
        Queue<String> ans = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s = reader.readLine();
            if (set.contains(s)) ans.offer(s);
        }

        System.out.println(ans.size());

        StringBuilder sb = new StringBuilder();
        while (!ans.isEmpty()) {
            sb.append(ans.poll() + '\n');
        }
        System.out.print(sb);
    }
}
