package dual_priority_queue_7662;

import java.io.*;
import java.util.*;

// 이중 우선순위 큐 (7662)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            t--;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(reader.readLine());
            for (int i = 0; i < k; i++) {
                String[] input = reader.readLine().split(" ");
                String oper = input[0];
                int num = Integer.parseInt(input[1]);
                if (oper.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    int value = map.get(key);
                    if (value - 1 == 0)
                        map.remove(key);
                    else
                        map.replace(key, value - 1);
                }
            }
            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}
