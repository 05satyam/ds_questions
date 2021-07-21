/**
 * You are given a list of N integers and you need to reverse it and print the reversed list in a new line.
 *
 * Input:
 * First-line will contain the number N.
 * Second line will contain N space-separated integers.
 * Output:
 * Print the reversed list in a single line.
 *
 * Constraints
 * 1≤N,Ai≤105
 * Sample Input 1:
 * 4
 * 1 3 2 4
 * Sample Output 1:
 * 4 2 3 1
 */
package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMe {

    static void reverseMe(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        for(int i=a.length-1;i>0;i--) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[0]);

    }

    public static void main(String[] a){
        reverseMe();
    }
}
