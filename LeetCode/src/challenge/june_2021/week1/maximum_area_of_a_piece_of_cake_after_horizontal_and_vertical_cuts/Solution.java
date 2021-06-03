package challenge.june_2021.week1.maximum_area_of_a_piece_of_cake_after_horizontal_and_vertical_cuts;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int c = s.maxArea(1_000_000_000, 1_000_000_000, new int[]{3, 1}, new int[]{1});
        System.out.println("c = " + c);

    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHeight = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);

        long maxWidth = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);

        return (int)(maxWidth * maxHeight % 1_000_000_007);
    }
}