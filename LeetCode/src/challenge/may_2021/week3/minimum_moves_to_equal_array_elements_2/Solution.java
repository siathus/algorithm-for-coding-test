package challenge.may_2021.week3.minimum_moves_to_equal_array_elements_2;

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums[nums.length / 2];
        int moves = 0;

        for (int i = 0; i < nums.length; i++) {
            moves += Math.abs(nums[i] - mid);
        }

        return moves;
    }
}
