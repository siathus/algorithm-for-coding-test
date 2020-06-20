package make_zero_7490;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static LinkedList<LinkedList<String>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < l; i++) {
            int n = Integer.parseInt(sc.nextLine());
            list = new LinkedList<>();

            getOperatorList(new LinkedList<>(), n - 1);

            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = j + 1;
            }
            for (LinkedList<String> oper : list) {
                String str = "";
                for (int j = 0; j < n - 1; j++) {
                    str = str + num[j] + oper.get(j);
                }
                str = str + num[n - 1];
                if (eval(str.replace(" ", "")) == 0) {
                    System.out.println(str);
                }
            }
            System.out.println();
        }
    }

    private static int eval(String str) {
        char[] arr = str.toCharArray();
        int sum = 0;
        int idx = 0;
        while(idx < arr.length) {
            if (arr[idx] == '+' || arr[idx] == '-') {
                break;
            }
            sum = (sum * 10) + (arr[idx] - '0');
            idx++;
        }
        while (idx < arr.length) {
            int sign = 1;
            int a = 0;
            if (arr[idx] == '-')
                sign = -1;
            idx++;
            while(idx < arr.length) {
                if (arr[idx] == '+' || arr[idx] == '-') {
                    break;
                }
                a = (a * 10) + (arr[idx] - '0');
                idx++;
            }
            sum = sum + (a * sign);
        }
        return sum;
    }

    private static void getOperatorList(LinkedList<String> operatorList, int len) {
        if (operatorList.size() == len) {
            LinkedList<String> tmp = new LinkedList<>(operatorList);
            list.add(tmp);
            return;
        }
        operatorList.add(" ");
        getOperatorList(operatorList, len);
        operatorList.removeLast();

        operatorList.add("+");
        getOperatorList(operatorList, len);
        operatorList.removeLast();

        operatorList.add("-");
        getOperatorList(operatorList, len);
        operatorList.removeLast();
    }
}
