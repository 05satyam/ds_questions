package leetcode;

public class OddOccurance {

    int oddOccurrencesOfZeros(int[] a) {
        String s="";
        int finalCount=0;
        for(int i=0;i<a.length;i++){
            s=String.valueOf(a[i]);
            if(s.length()==1 && (s.charAt(0)!='0') )
                continue;

            int countZero=0;
            for(int k=0;k<s.length();k++){
                if(s.charAt(k)=='0'){
                    countZero++;
                }


            }

            if(countZero%2!=0){
                finalCount++;
            }
        }

        return finalCount;
    }


}
