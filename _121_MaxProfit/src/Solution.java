public class Solution {
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/comments/

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];

            if (prices[i] - min > max)
                max = prices[i] - min;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}