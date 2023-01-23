/**
 * solution from leet code
 *
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 */
package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        // Start at an eating speed of 1.
        int speed = 1;

        while (true) {
            // hourSpent stands for the total hour Koko spends with
            // the given eating speed.
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / speed)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / speed);
                if (hourSpent > h) {
                    break;
                }
            }

            // Check if Koko can finish all the piles within h hours,
            // If so, return speed. Otherwise, let speed increment by
            // 1 and repeat the previous iteration.
            if (hourSpent <= h) {
                return speed;
            } else {
                speed += 1;
            }
        }
    }

   
    public static void main(String[] a){
        int arr[] = {312884470};
        System.out.println(minEatingSpeed(arr,312884469));
    }

}
