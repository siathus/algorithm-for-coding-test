package ioioi_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// IOIOI (5525)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split("");

        int ans = 0;
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            if (s[i - 1].equals("I") && s[i].equals("O") && s[i + 1].equals("I")) {
                count++;
                if (count == n) {
                    ans++;
                    count--;
                }
                i++;
            } else {
                count = 0;
            }
        }
        System.out.println(ans);
    }
}
