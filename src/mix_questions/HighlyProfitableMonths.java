package mix_questions;

import java.util.Arrays;
import java.util.List;

public class HighlyProfitableMonths {
    public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
        // Write your code here
        int arr[] = new int[stockPrices.size()];
        Arrays.fill(arr, 0);
        int count=0;
        int subarrcount=1;
       for(int i=1;i<stockPrices.size();i++){
           if(stockPrices.get(i)>stockPrices.get(i-1)){
               arr[i]=arr[i-1]+1;
               subarrcount++;
           }

           if(subarrcount==k)
               count++;
           subarrcount=0;
       }
       return count;
    }


}
