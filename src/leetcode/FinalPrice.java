/*
*
Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.

Example 1:

Input: prices = [8,4,6,2,3]
Output: [4,2,4,2,3]
Explanation:
For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
For items 3 and 4 you will not receive any discount at all.
* */


package leetcode;

public class FinalPrice {
    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        boolean found=false;

        for(int i=0;i<prices.length;i++){
            found=false;
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]>=prices[j]){
                    res[i]=prices[i]-prices[j];
                    found=true;
                    break;
                }
            }

            if(!found)
                res[i]=prices[i];
        }
        return res;
    }
}
