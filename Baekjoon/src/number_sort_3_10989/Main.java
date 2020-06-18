package number_sort_3_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(reader.readLine())]++;
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < arr[i]; j++) {
                writer.write(i + "\n");
            }
        }
        writer.close();
        reader.close();
    }
}
