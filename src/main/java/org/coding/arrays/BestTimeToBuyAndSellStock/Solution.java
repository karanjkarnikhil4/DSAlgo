package org.coding.arrays.BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n-1];
        int[] maxSellableMaxPrice = new int[n];
        maxSellableMaxPrice[n-1] = prices[n-1];

        for(int i =n-2; i>=0; i-- )
        {
            if(prices[i] > max)
            {
                maxSellableMaxPrice[i] = prices[i];
                max =prices[i];
            }
            else
            {
                maxSellableMaxPrice[i] = max;
            }
        }
        int profit =0;
        for(int i =0; i < n; i++)
        {
            if(maxSellableMaxPrice[i] - prices[i] >profit)
            {
                profit = maxSellableMaxPrice[i] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{98, 178 ,250 ,300 ,40 ,540,690}));
    }
}