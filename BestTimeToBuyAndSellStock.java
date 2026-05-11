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
        System.out.println("Test 1: " + sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("Test 2: " + sol.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println("Test 3: " + sol.maxProfit(new int[]{2,4,1}));
    }
}
