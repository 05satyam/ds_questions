/**
 * QUESTION2
 *
 * Raju is planning to visit his favourite restaurant. He shall travel to it by bus. Only the buses whose numbers are divisible by 5 or by 6 shall take him to his destination. You are given a bus number N. Find if Raju can take the bus or not. Print YES if he can take the bus, otherwise print NO.
 *
 * Input:
 * The first and only line of the input shall contain an integer N, denoting the bus number.
 * Output:
 * Print YES if Raju can take that bus, else print NO.
 *
 * Constraints
 * 1≤N≤106
 * Sample Input 1:
 * 60
 * Sample Output 1:
 * YES
 */
package codechef;

import java.util.Scanner;

public class RajuTakeABus {
    public static String canReachDestination(int n){
        if(n%5==0 || n%6==0)
            return "YES";
      return "NO";
    }
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        System.out.println(canReachDestination(n));
    }
}
