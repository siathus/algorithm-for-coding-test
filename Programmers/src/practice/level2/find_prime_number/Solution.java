package practice.level2.find_prime_number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// 완전탐색 > 소수 찾기
public class Solution {
    Set<Integer> visited = new HashSet<>();

    public int solution(String numbers) {
        int len = numbers.length();
        char[] arr = new char[len];

        for (int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i);
        }

        for (int i = 1; i <= len; i++) {
           permutation(arr, 0, i);
        }

        return visited.size();
    }

    private void permutation(char[] arr, int depth, int r) {
        if (depth == r) {
            String s = "";
            for (int i = 0; i < r; i++) {
                s = s + arr[i];
            }
            int num = Integer.parseInt(s);
            System.out.println(num);
            if (num < 2 || visited.contains(num)) {
                return;
            }
            boolean isPrime = true;
            for (int i = 2; i <= (num / 2); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                visited.add(num);
                return;
            }
        }

        for (int i = depth; i < arr.length; i++) {
            char tmp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = tmp;

            permutation(arr, depth + 1, r);

            arr[i] = arr[depth];
            arr[depth] = tmp;
        }
    }
}
