/**
 *
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */

package leetcode;

import java.util.*;

public class PowerSuperSet {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n= nums.length;
        int totalSet = (int)Math.pow(2, n);
        Set<List<Integer>> resSet = new HashSet<>();
        for(int i=0;i<totalSet;i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j)) >0){
                    subset.add(nums[j]);
                }
            }
           Collections.sort(subset);
           resSet.add(subset);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Iterator<List<Integer>> it = resSet.iterator(); it.hasNext(); ) {
            List<Integer> f = it.next();
            res.add(f);
        }

        return res;
    }

}
