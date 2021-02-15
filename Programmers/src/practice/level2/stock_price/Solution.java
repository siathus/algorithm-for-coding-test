package practice.level2.stock_price;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] >= price) {
                    answer[i]++;
                } else {
                    price = prices[j];
                }
            }
        }
        return answer;
    }
}
