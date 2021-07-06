package ac_5430;

import java.io.*;
import java.util.*;

// AC (5430)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String str = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "[],");
            Deque<String> deque = new ArrayDeque<>();

            while (tokenizer.hasMoreTokens()) {
                deque.offer(tokenizer.nextToken());
            }

            int reversed = 1;
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'R') reversed *= -1;
                else {
                    if (deque.isEmpty()) {
                        output = new StringBuilder("error");
                        break;
                    }
                    if (reversed == 1) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if (!output.toString().equals("error")) {
                output.append("[");
                if (!deque.isEmpty()) {
                    if (reversed == 1) {
                        output.append(deque.pollFirst());
                        while (!deque.isEmpty()) {
                            output.append("," + deque.pollFirst());
                        }
                    } else {
                        output.append(deque.pollLast());
                        while (!deque.isEmpty()) {
                            output.append("," + deque.pollLast());
                        }
                    }
                }
                output.append("]");
            }
            sb.append(output + "\n");
        }
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}
