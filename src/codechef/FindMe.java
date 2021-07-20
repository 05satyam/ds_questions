/**
 * First question of codechef
 *
 * You are given a list of N integers and a value K. Print 1 if K exists in the given list of N integers, otherwise print −1.
 *
 *
 * Input:
 * First-line will contain two numbers N and K.
 * Next line contains N space-separated numbers.
 * Output:
 * Print the answer in a new line.
 *
 * Constraints
 * 1≤N,K,Ai≤105
 *
 *
 * Sample Input 1:
 * 4 2
 * 1 2 3 4
 * Sample Output 1:
 * 1
 */
package codechef;

import java.util.Scanner;

public class FindMe {
    static int findMe(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0;i<n;i++)
            if(sc.nextInt()==k)return 1;

        return -1;
    }

    public static void main(String[] a){
        System.out.println(findMe());
    }
}
