package big_number_a_plus_b_10757;

import java.math.BigInteger;
import java.util.Scanner;

// 큰 수 A+B (10757)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        BigInteger a = new BigInteger(numbers[0]);
        System.out.println(a.add(new BigInteger(numbers[1])));
    }
}
