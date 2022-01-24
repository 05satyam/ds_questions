package leetcode;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int minVal=prices[0];
        int maxProfit =Integer.MIN_VALUE;

        for(int i=1;i<prices.length;i++){
            int c = prices[i]-minVal;
            if(c<0 && prices[i]<minVal)
                minVal=prices[i];
            if(c>maxProfit)
                maxProfit=c;
        }
        return maxProfit;
    }
}
