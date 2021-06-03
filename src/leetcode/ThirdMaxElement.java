/**
 * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The third maximum is 1.
 */
package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ThirdMaxElement {
    public int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();

        for(int i : nums)
        {
            set.add(i);
        }

        if(set.size() >= 3)
        {
            set.pollLast();
            set.pollLast();
        }

        return set.last();
    }
}
