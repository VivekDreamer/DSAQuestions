// https://www.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
public class POTD_StockBuyAndSellMultipleTransactionAllowed {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int profit = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i-1])
                profit += (prices[i]-prices[i-1]);
        }
        return profit;
    }
}
