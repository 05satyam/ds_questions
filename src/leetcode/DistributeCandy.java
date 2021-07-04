/**
 * Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.
 *
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
 *
 * Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
 *
 *
 *
 * Example 1:
 *
 * Input: candyType = [1,1,2,2,3,3]
 * Output: 3
 * Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandy {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<candyType.length;i++)
            set.add(candyType[i]);

        int len = candyType.length/2;

        return len<set.size()? len: set.size();
    }

    //solution2


    public int distributeCandies2(int[] candyType) {
        final Set<Integer> types = new HashSet<>(candyType.length / 2);

        for (int type : candyType) {
            types.add(type);

            if (candyType.length / 2 <= types.size()) {
                return candyType.length / 2;
            }
        }

        return types.size();
    }
}
