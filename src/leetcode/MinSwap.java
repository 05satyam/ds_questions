/**
 * Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
 */
package leetcode;

public class MinSwap {
    public static int minSwap(String s){
        String sCpy = s;
        char ss[]=s.toCharArray();
       // System.out.println("ss length "+ ss.length);
        int dist=0;
        int i=0;
        for(int j=s.length()-1;i<s.length()-1 && j>=0;){
          //  System.out.println("i, j  " + i + "   "+ j);
            if(ss[i]==ss[j]){
                i++; j--;
                continue;
            }

            boolean swapDone = false;
           // System.out.println("elem not matched  , j  , i     "+ j   +"   "+ i);
            for(int k=j-1;k>i;k--){
            //    System.out.println("in for k "+ k);
                char temp = ss[j];
                ss[j]=s.charAt(k);
                ss[k]=temp;

                if(ss[j]==ss[i]){
                   dist+=(j-k);
                   swapDone=true;
                   break;
                }else{
                    temp=ss[j];
                    ss[j]=ss[k];
                    ss[k]=temp;
                }
            }

            if(!swapDone){
               char  temp=ss[i];
                ss[i]=ss[i+1];
                ss[i+1]=temp;
                dist+=1;
                //i++;

            }else{
            }


        }
i=0;
        for( i=0;i<ss.length;i++){
            System.out.print(ss[i] + "   ");

        }
        System.out.println();
        for( int j=ss.length-1;i<ss.length/2;i++, j--){
            System.out.print(ss[i] + "   ");
            if(ss[i]!=ss[j])
                return -1;
        }

        return dist;
    }


    public static void main(String[] a){
        //System.out.println(minSwap("abba"));
        //System.out.println(minSwap("aba"));
        //System.out.println(minSwap("abc"));
        //System.out.println(minSwap("abaa"));
        //System.out.println(minSwap("a"));
        System.out.println(minSwap("mamad"));
        //System.out.println(minSwap("aabb"));
        //System.out.println(minSwap("ntiin"));

    }
}
