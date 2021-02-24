package practice.level2.biggest_number;

import java.util.Arrays;
import java.util.Comparator;

// 정렬 > 가장 큰 수
public class Solution {
    public static void main(String[] args) {

        String[] a = {"0", "0", "0"};
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.parseInt(first + second) - Integer.parseInt(second + first);
            }
        });
        StringBuffer result = new StringBuffer();
        for (int i = a.length - 1; i >= 0; i--) {
            result.append(a[i]);
        }

        System.out.println(result.toString());
    }
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return Integer.parseInt(first + second) - Integer.parseInt(second + first);
            }
        });
        StringBuffer result = new StringBuffer();
        for (int i = stringNumbers.length - 1; i >= 0; i--) {
            result.append(stringNumbers[i]);
        }
        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}
