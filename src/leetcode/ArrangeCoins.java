/**
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 *Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 */
package leetcode;

public class ArrangeCoins {
    public static int arrangeCoins(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(i<=n){
                count++;
                n=n-i;
            }else{
                break;
            }
        }
        return count;
    }
    public static void main(String[] a){
        System.out.println(arrangeCoins(5));
    }
}
