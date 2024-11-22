// https://www.geeksforgeeks.org/problems/buy-stock-2/1
public class POTD_StockBuyAndSellMaxOneTransactionAllowed {
    public int maximumProfit(int prices[]) {
        int maxCount = 0;
        int buyPrice = prices[0];
        for(int i = 1;i<prices.length;i++) {
            if(prices[i] > buyPrice) {
                maxCount =  Math.max(prices[i] - buyPrice,maxCount);
            } else {
                buyPrice =  prices[i];
            } 
        }
        return maxCount;
    }
}
