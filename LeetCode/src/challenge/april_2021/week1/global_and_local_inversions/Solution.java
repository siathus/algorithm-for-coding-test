package challenge.april_2021.week1.global_and_local_inversions;

class Solution {
    public boolean isIdealPermutation(int[] nums) {
//        int global = 0, local = 0;
//        int n = nums.length;
//
//        for (int i = 0; i < n; i++) {
//            if (i < n - 1) {
//                if (nums[i] > nums[i + 1]) local++;
//            }
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] > nums[j]) global++;
//            }
//        }
//        return global == local;

        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i + 2] < max) {
                return false;
            }
        }
        return true;
    }
}