package coordinate_compression_18870;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 좌표 압축 (18870)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> coordinates = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> comp = new HashSet<>(coordinates)
                .stream()
                .collect(Collectors.toList());
        comp.sort(Comparator.comparingInt(o -> o));

        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : comp) {
            map.put(i, index++);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer coordinate : coordinates) {
            sb.append(map.get(coordinate) + " ");
        }

        writer.write(sb.toString().trim());
        writer.flush();
        writer.close();
        reader.close();
    }
}
