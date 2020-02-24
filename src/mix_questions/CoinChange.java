package mix_questions;

import java.util.Arrays;

public class CoinChange {
	public static int countWaysToMakeChange(int denominations[], int value){
		return count(denominations, denominations.length,value);
	}
	static int count( int S[], int m, int n ) 
    { 
         int[] table = new int[n+1]; 
        Arrays.fill(table, 0);   //O(n) 
        table[0] = 1; 
        for (int i=0; i<m; i++) 
            for (int j=S[i]; j<=n; j++) 
                table[j] += table[j-S[i]]; 
  
        return table[n]; 
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c[] =  new int[3];
		c[0]=1;
		c[1]=2;
		c[3]=4;
		countWaysToMakeChange(c,5);
	}

}
