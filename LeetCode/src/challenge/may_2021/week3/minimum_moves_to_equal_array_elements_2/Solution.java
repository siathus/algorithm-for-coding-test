package challenge.may_2021.week3.minimum_moves_to_equal_array_elements_2;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {1, 0, 0, 8, 6};
        System.out.println(s.minMoves2(nums));
    }
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
