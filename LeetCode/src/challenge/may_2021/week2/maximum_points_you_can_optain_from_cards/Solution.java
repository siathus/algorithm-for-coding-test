package challenge.may_2021.week2.maximum_points_you_can_optain_from_cards;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0, right = k - 1;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;

        while (right >= 0) {
            sum = sum - cardPoints[right--] + cardPoints[--left + cardPoints.length];
            Math.max(max, sum);
        }

        return max;
    }
}