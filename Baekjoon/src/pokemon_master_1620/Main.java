package pokemon_master_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 나는야 포켓몬 마스터 (1620)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = reader.readLine();
            numberMap.put(i, name);
            nameMap.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String s = reader.readLine();
            if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                System.out.println(nameMap.get(s));
            } else {
                System.out.println(numberMap.get(Integer.parseInt(s)));
            }
        }
    }
}
