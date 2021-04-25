package challenge.april_2021.week2.beautiful_arrangement_2;

class Solution {
    public int[] constructArray(int n, int k) {
        int between = n - k;
        int[] arr = new int[n];
        int idx = 0;
        int startNumber = 1, endNumber = n - between + 1;

        while (startNumber <= endNumber) {
            if (startNumber == endNumber) {
                arr[idx++] = startNumber;
                break;
            }
            arr[idx++] = startNumber++;
            arr[idx++] = endNumber--;
        }

        endNumber = n - between + 2;

        for (int i = idx; i < n; i++) {
            arr[i] = endNumber++;
        }
        return arr;
    }
}