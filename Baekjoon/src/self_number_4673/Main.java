package self_number_4673;

// 셀프 넘버 (4673)
public class Main {

    private static int[] numbers = new int[20000];
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            d(i);
        }
        for (int i = 1; i <= 10000; i++) {
            if (numbers[i] == 0) {
                System.out.println(i);
            }
        }
    }

    private static void d(int n) {
        int sum = n;
        String a = String.valueOf(n);
        for (int i = 0; i < a.length(); i++) {
            sum += a.charAt(i) - '0';
        }
        numbers[sum] = 1;
    }
}
