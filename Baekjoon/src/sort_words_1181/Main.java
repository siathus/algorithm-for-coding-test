package sort_words_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(reader.readLine());
        int n = sc.nextInt();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            System.out.println("word = " + word);
            if (!words.contains(word)) words.add(word);
        }

        System.out.println("words.size() = " + words.size());

        Collections.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        words.stream().forEach(System.out::println);
    }
}
