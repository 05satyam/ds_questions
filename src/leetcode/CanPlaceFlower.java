/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 */
package leetcode;

public class CanPlaceFlower {
    //Solution1
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++) {
            int pre = i-1 < 0 ? 0 : flowerbed[i-1];
            int post = i+1 >= flowerbed.length ? 0 : flowerbed[i+1];
            int curr = flowerbed[i];
            if(pre == 0 && post == 0 && curr == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n > 0 ? false : true;
    }
    public static void main(String[] a){
        int arr[]= new int[6];
        arr[0]=1;
        arr[1]=0;
        arr[2]=0;
        arr[3]=0;
        arr[4]=0;
        arr[5]=1;
        System.out.println(canPlaceFlowers(arr, 2));
    }
}
