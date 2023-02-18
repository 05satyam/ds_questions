/***
 *
 * Next lexographically lrger permutation
 *
 *
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist)
    {
        // Arraylist for storing reversed elements
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {

            // Append the elements in reverse order
            revArrayList.add(alist.get(i));
        }

        // Return the reversed arraylist
        return revArrayList;
    }
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation)
    {

        // Write your code here.
        ArrayList<Integer>temp = new ArrayList<>();
        int n = permutation.size()-1;
        if(n==0)
            return permutation;

        int k=0;
        for(k=n-1;k>=0;k--){
            if(permutation.get(k)<permutation.get(k+1))
                break;
        }
        System.out.println("k" + k);
        if(k<0) {
            Collections.reverse(permutation);
            return permutation;
        }
        int breakIdx=-1;
        System.out.println("size "+ n);
        for(int i=n;i>0;i--){
            for(int j=i-1;j>=0;j--){

                System.out.println(permutation.get(i) + "    "+permutation.get(j) );
                if(permutation.get(i)>permutation.get(j)){
                    System.out.println("inside ");
//                    temp.add(permutation.get(i));
//                    temp.add(permutation.get(j));
//
                    int temp1 = permutation.get(i);
                    permutation.set(i,permutation.get(j));
                    permutation.set(j, temp1);
                    breakIdx = j;
                    break;

                }

            }
            if(breakIdx!=-1)
                break;
        }
        ArrayList res=new ArrayList();
        if(breakIdx!=-1){
            for(int i=0;i<=breakIdx;i++){
                res.add(permutation.get(i));
            }


            for(int i=n;i>breakIdx;i--)
                res.add(permutation.get(i));
        }


        return res;


    }

    public static void main(String[] a){
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3); input.add(1); input.add(2); //input.add(4); //input.add(5);

        ArrayList<Integer> res = nextPermutation(input);
        for(Integer aa: res)
            System.out.print(aa + "  ");

        System.out.println();
    }
}
