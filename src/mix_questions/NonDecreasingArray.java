package mix_questions;

import java.util.Scanner;

public class NonDecreasingArray {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();


        nonDecreasingSubArray( t, s);

    }
    public static void nonDecreasingSubArray(int t, Scanner s){
        while(t-->0) {
            int n = s.nextInt();
            int arr[] = new int[n];
            int bRes[] = new int[n];

            for(int i = 0; i<n;i++){
                arr[i] = s.nextInt();
                if(i==0)
                    bRes[0]= arr[0];
                else{
                    if(arr[i]<bRes[i-1]){

                        int quo = bRes[i-1]/arr[i];
                        int finalNum = quo*arr[i];
                        if(finalNum<bRes[i-1])
                            finalNum= (quo+1)*arr[i];
                        int xMid = (bRes[i-1]%arr[i]==0)? bRes[i-1]: finalNum;
                        bRes[i]=xMid;
                    }else{
                        bRes[i]=arr[i];
                    }
                }
            }


            for(int k=0;k<bRes.length;k++){
                System.out.print(bRes[k] + " ");
            }
            System.out.println();
        }
    }
}
