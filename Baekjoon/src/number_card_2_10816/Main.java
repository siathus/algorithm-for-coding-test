package number_card_2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 숫자 카드 2 (10816)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 한 줄을 통째로 읽기 때문에 첫 줄에 나오는 N은 필요가 없으므로 생략
        reader.readLine();

        String[] input = reader.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for (String str : input) {
            int num = Integer.parseInt(str);
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 한 줄을 통째로 읽기 때문에 첫 줄에 나오는 N은 필요가 없으므로 생략
        reader.readLine();

        input = reader.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (String str : input) {
            int num = Integer.parseInt(str);
            if (map.containsKey(num)) sb.append(map.get(num) + " ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }
}
