package sum_of_section_4_11659;

import java.io.*;

// 구간 합 구하기 4 (11659)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] acc = new int[n + 1];
        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            acc[i + 1] = Integer.parseInt(input[i]) + acc[i];
        }

        StringBuilder output = new StringBuilder();
        for (int k = 0; k < m; k++) {
            input = reader.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);

            output.append((acc[j] - acc[i - 1]) + "\n");
        }
        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}
