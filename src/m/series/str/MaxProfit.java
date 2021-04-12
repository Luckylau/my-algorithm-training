package m.series.str;

/**
 * @Author luckylau
 * @Date 2021/4/12
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                res = Math.max(prices[i] - minPrice, res);
            }
        }
        return res;
    }
}
