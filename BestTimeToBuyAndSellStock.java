// LeetCode #121 - Best Time to Buy and Sell Stock
// NeetCode: Sliding Window
// Difficulty: Easy
//
// Problem:
// You are given an array prices where prices[i] is the price of a stock on day i.
// Return the maximum profit you can achieve from one buy and one sell.
// If no profit is possible, return 0.
//
// Example:
// Input: prices = [7,1,5,3,6,4]
// Output: 5 (Buy on day 2 at price 1, sell on day 5 at price 6)
//
// Approach: Two Pointers (min tracker) - O(n) Time | O(1) Space

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        System.out.println("Test 1: " + sol.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println("Test 2: " + sol.maxProfit(new int[]{7,6,4,3,1}));   // 0
        System.out.println("Test 3: " + sol.maxProfit(new int[]{2,4,1}));        // 2
    }
}
