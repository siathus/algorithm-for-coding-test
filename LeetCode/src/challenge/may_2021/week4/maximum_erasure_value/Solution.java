package challenge.may_2021.week4.maximum_erasure_value;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] nmap = new int[10001];
        int total = 0, max = 0;
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            nmap[nums[right]]++;
            total += nums[right];
            while (nmap[nums[right]] > 1) {
                nmap[nums[left]]--;
                total -= nums[left++];
            }
            max = Math.max(max, total);
        }
        return max;
    }
}