package challenge.june_2021.week1.maximum_area_of_a_piece_of_cake_after_horizontal_and_vertical_cuts;

import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHeight = maximumSizeOfCuts(h, horizontalCuts);

        long maxWidth = maximumSizeOfCuts(w, verticalCuts);

        return (int)(maxWidth * maxHeight % 1_000_000_007);
    }

    private int maximumSizeOfCuts(int range, int[] cuts) {
        int max = cuts[0];
        int len = cuts.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, (cuts[i] - cuts[i - 1]));
        }
        max = Math.max(max, (range - cuts[len - 1]));
        return max;
    }
}