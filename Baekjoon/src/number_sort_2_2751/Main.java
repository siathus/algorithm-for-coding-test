package number_sort_2_2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(reader.readLine()));
        }
        reader.close();
        Collections.sort(arr);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : arr) {
            writer.write(a + "\n");
        }
        writer.close();
    }
}
