/**
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 */

ackage leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> frequncyMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(frequncyMap.containsKey(nums[i]))
                frequncyMap.put(nums[i], frequncyMap.get(nums[i])+1);
            else
                frequncyMap.put(nums[i], 1);

        }

        for(Map.Entry<Integer, Integer> kv : frequncyMap.entrySet()){
            if(kv.getValue()==2)
                res.add(kv.getKey());
        }
        return res;
    }
}
