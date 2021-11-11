package leetcode;

import java.util.*;

public class SortAccordingToBouncingDiag {
    static int[] bouncingDiagonals(int[][] matrix) {
        int j=matrix[0].length;
        int matLen=matrix.length;
        HashMap<Integer, Integer> bouncingMap = new HashMap<>();
        for(int i=0;i<matLen;i++){
            int bouncingDigSum=matrix[i][0];
            int bouncingJ=1;
            int upI=i-1;
            for(;upI>=0 && bouncingJ<=j-1;upI--, bouncingJ++){
                bouncingDigSum+=matrix[upI][bouncingJ];
            }

            if(bouncingJ==j) {
                bouncingMap.put(i, bouncingDigSum);
                continue;
            }
            if(upI<0)
                upI=1;

            for(; upI<matLen && bouncingJ<=j-1;upI++, bouncingJ++){
                bouncingDigSum+=matrix[upI][bouncingJ];
            }

            if(bouncingJ==j) {
                bouncingMap.put(i, bouncingDigSum);

            }
        }

        return sortByValue(bouncingMap, matrix);
    }
    public static  int[] sortByValue(HashMap<Integer, Integer> hm, int[][] m)
    {
        int ress []= new int[hm.size()];
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
       int  k=0;
        for (Map.Entry<Integer, Integer> aa : list) {
            ress[k]=m[aa.getKey()][0];
            k++;
        }
        return ress;
    }


    public static void main(String[] a){
        int input[][] = new int[3][3];
        input[0][0]=2;
        input[0][1]=3;
        input[0][2]=2;


        input[1][0]=0;
        input[1][1]=2;
        input[1][2]=5;


        input[2][0]=1;
        input[2][1]=0;
        input[2][2]=1;

        int res[] = bouncingDiagonals(input);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]   +"     " );
     }
}
