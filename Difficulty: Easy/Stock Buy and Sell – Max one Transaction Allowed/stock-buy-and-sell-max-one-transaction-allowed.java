class Solution {
     static int maxProfit(int []prices) {
    int buy = prices[0], sell = prices[0], profit = 0;

    for (int i = 0; i < prices.length; i++) {
        if (buy > prices[i]) {
            buy = prices[i];
            sell = prices[i];
        }
        if (sell < prices[i]) {
            sell = prices[i];
        }
        profit = Math.max(profit, sell - buy);
    }
    return profit;
}
}