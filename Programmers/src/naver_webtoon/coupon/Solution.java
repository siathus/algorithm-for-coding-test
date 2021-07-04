package naver_webtoon.coupon;

import java.util.Arrays;

public class Solution {
    public int solution(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int pricesIndex = prices.length - 1;
        int discountsIndex = discounts.length - 1;
        double total = 0;

        while (pricesIndex >= 0 && discountsIndex >= 0) {
            total += prices[pricesIndex--] * (1 - (discounts[discountsIndex--] / 100f));
            System.out.println("total = " + total);
        }

        // 제품의 수가 쿠폰 수보다 많을 때, 남은 제품의 가격 합산
        while (pricesIndex >= 0) {
            total += prices[pricesIndex--];
        }

        return (int)total;
    }
}
