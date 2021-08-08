package mix_questions;

import java.util.List;

public class HighlyProfitableMonths {
    public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
        // Write your code here
        int i=0, count=0;
        //System.out.println(stockPrices.size()-k);
        for(i=0;i<=stockPrices.size()-k;i++){
            boolean found=false;
            for(int j=i+1;j<(i+k);j++){
                //System.out.print(" "+  stockPrices.get(j) + "  ");
                if(stockPrices.get(j-1).intValue()>=stockPrices.get(j).intValue()){
                    found=true;
                    break;
                }

            }

            System.out.print(". found. "+found);
            if(!found){
                count++;
                if((i+k)<stockPrices.size()-1){
                    System.out.println(stockPrices.get(i+k-1).intValue() +"     "+ stockPrices.get(i+k).intValue());
                    if((stockPrices.get(i+k-1).intValue() < stockPrices.get(i+k).intValue()) ){
                        count++;
                        i=i+k;}
                }

            }
            System.out.println();
        }
        return count;
    }


}
