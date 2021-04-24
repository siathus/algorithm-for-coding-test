package challenge.april_2021.week1.minimum_operations_to_make_array_equal;

class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (2 * i) + 1;
        }
        int count = 0;
        int y = 0, x = n - 1;
        int medium = (arr[y] + arr[x]) / 2;

        while (y <= x) {
            count += medium - arr[y];
            y++;
            x--;
        }
        return count;
    }
}