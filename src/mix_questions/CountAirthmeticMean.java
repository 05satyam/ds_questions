package mix_questions;

public class CountAirthmeticMean {
    int countArithmeticMeans(int[] a) {
        int count=0;
        for(int i=0;i<a.length;i++){
            int x0=0;
            if(i!=0)
                x0=a[i-1];
            int x1 = a[i];

            int x2=0;
            if(i!=a.length-1)
            x2=a[i+1];

            if((x0+x2)==(2 * x1))
                count++;
        }
        return count;
    }

}
