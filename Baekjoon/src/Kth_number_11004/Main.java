package Kth_number_11004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = sc.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(sc.readLine());
        
        int idx = 0;
        while (tokenizer.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(tokenizer.nextToken());
        }

        quickSelection(0, n - 1, k - 1);
    }

    private static int partition(int left, int right) {
        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (arr[i] <= pivot && i <= right) {
                i++;
            }
            while (arr[j] >= pivot && j >= (left + 1)) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[left];
        arr[left] = arr[j];
        arr[j] = tmp;
        return j;
    }
    private static void quickSelection(int left, int right, int k) {
        int n = partition(left, right);

        if (n == k) {
            System.out.println(arr[n]);
            return;
        }
        else if (n > k) quickSelection(left, n - 1, k);
        else if (n < k) quickSelection(n + 1, right, k);
        return;
    }
}
