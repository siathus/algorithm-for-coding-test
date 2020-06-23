package search_docs_1543;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String doc = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;
        int idx;
        while (doc.contains(word)) {
            idx = doc.indexOf(word);
            doc = doc.substring(idx + word.length());
            count++;
        }

        System.out.println(count);
    }
}
