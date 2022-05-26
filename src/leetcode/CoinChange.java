package leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount+1];
        for(int i=0;i<amount+1;i++){
            table[i] = 2147448;
        }

        table[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0)
                    table[i] = Math.min(table[i], 1+ table[i-coins[j]]);
            }
        }
        return table[amount]== 2147448 ? -1: table[amount];
    }
}