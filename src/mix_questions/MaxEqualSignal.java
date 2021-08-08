/**
 * equal level qstion ---PIMCO
 */
package mix_questions;

import java.util.List;

public class MaxEqualSignal {
    /*
     * Complete the 'updateTimes' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY signalOne
     *  2. INTEGER_ARRAY signalTwo
     */

    public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        // Write your code here
        int i=0, j=0;
        int maxVal=Integer.MIN_VALUE;
        int count=0;
        while(i<signalOne.size() && j<signalTwo.size()){
            //System.out.print(signalOne.get(i) + "   " + signalTwo.get(j) + "   is equal " +(signalOne.get(i).intValue()==signalTwo.get(j).intValue()? true: false ));
            if(signalOne.get(i).intValue()==signalTwo.get(j).intValue()){
                //System.out.print(".   inside equal " );
                if(maxVal<signalOne.get(i).intValue()){
                    //System.out.print(".   max val found " );
                    maxVal=signalOne.get(i);
                    count++;
                    //System.out.print(".   count = " + count ) ;
                }
            }
            i++;
            j++;
            System.out.println();
        }
        return count;
    }
}
