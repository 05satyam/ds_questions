package mix_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AStrangeSum {
    public static int mod = 1000000007;
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) );
        int t = Integer.parseInt( br.readLine() );

        getStrangeSum(t, br);


    }


    public static void getStrangeSum(int t, BufferedReader br) throws IOException {
        //int[] arr = new int[10000000];
        Map<Integer, Integer> arr = new HashMap<>();

        //Arrays.fill(arr, -1);
        while(t-->0){
            String[] nm= br.readLine().split(" ");
            int n= Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            //calculateDivisorsCountForN(n, arr);
            //int[] arr = new int[n+1];
            //
            int sum=0;
            for(int ii=1;ii<=n;ii++){
                int count=0;
                if(arr.get(ii)!=null){
                   count=arr.get(ii);
                }else{
                for (int i=1; i<=Math.sqrt(ii); i++) {
                    if (ii%i==0) {
                        if (ii/i == i)
                            count++;
                        else
                            count +=2;
                    }

                 }
                    arr.put(ii, (count));
                }

                sum+= (Math.pow(ii, m) * count);
            }

            System.out.println(sum);
        }
    }

}
