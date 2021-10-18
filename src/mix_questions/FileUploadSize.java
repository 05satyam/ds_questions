package mix_questions;

import java.util.HashSet;
import java.util.Set;

public class FileUploadSize {
    Set<Long> sizeSet  = new HashSet<>();


    long[] fileUploadingProgress(long[][] chunks) {
        long sum = 0;
        long []res  = new long[chunks.length];
        int superMax = Integer.MIN_VALUE;
        int superMin = Integer.MAX_VALUE;
        for(int i=0;i<chunks.length;i++){
            long min = chunks[i][0];
            long max = chunks[i][1];
            long rangeSum=0;

            for(long k=min;k<=max;k++){
                if(!sizeSet.contains(k)){
                     sizeSet.add(k);
                    rangeSum++;
                }
            }
            sum+=rangeSum;
            if(rangeSum==0){
                rangeSum=max-min+1;
            }

            res[i]=sum;
        }

        return res;
    }
}

