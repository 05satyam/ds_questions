/**
 * You're given two numbers L and R. Print all odd numbers between L and R (both inclusive) in a single line separated by space, in ascending (increasing) order.
 *
 * Input:
 * First-line will contain two numbers L and R.
 * Output:
 * Print all odd numbers in a single line separated by space, in ascending (increasing) order.
 *
 * Constraints
 * 1≤L<R≤106
 * Sample Input 1:
 * 2 9
 * Sample Output 1:
 * 3 5 7 9
 * Sample Input 2:
 * 3 4
 * Sample Output 2:
 * 3
 */
package codechef;

import java.util.Scanner;

public class PrintOdd {
    static void printOdd(){
        Scanner sc  = new Scanner(System.in);
        int l=sc.nextInt();
        int h=sc.nextInt();
        for(int i=l;i<h-1;i++){
            if(i%2!=0)
                System.out.print(i +" ");
        }

        if((h-1)%2!=0)
            System.out.print(h-1);
        else
            System.out.print(h);
    }
    public static void main(String[] a){
        printOdd();
    }
}
