/**
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
 *
 * If it cannot be done, return -1.
 *
 *
 *  tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 */
package leetcode;

import java.util.Arrays;
import java.util.zip.ZipEntry;

public class MinimumDominoRotation {
    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int topElemFreq[]= new int[7];
        int bottomElemFreq[]= new int[7];
        int same[]= new int[7];
        Arrays.fill(topElemFreq,0);
        Arrays.fill(bottomElemFreq,0);
        Arrays.fill(same,0);


        for(int i=0;i<tops.length;i++){
            topElemFreq[tops[i]]++;
            bottomElemFreq[bottoms[i]]++;
            if(tops[i]==bottoms[i]){
                same[tops[i]]++;
            }
        }

        for(int i=0;i<7;i++){
            if(tops.length== (topElemFreq[i]+ bottomElemFreq[i])-same[i])
                return (tops.length-(Math.max(topElemFreq[i], bottomElemFreq[i])));

        }
        return -1;
    }

    public static void main(String[] a){
        int tops[]={3,5,1,2,3};
        int bottoms[] = {3,6,3,3,4};

        System.out.println(minDominoRotations(tops, bottoms));
    }
}
