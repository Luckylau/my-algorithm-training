package l.series;

/**
 * @Author luckylau
 * @Date 2020/1/10
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {13, 3, 6, 8, 4, 5};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(prices));
        System.out.println(maxProfit.maxProfitV2(prices));
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfitV2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }


}
