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

package leetcode;

import java.util.*;

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

    //SOlution 2
    public List<Integer> findDuplicates1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> frequncyMap = new HashMap<>();
        int a=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++) {
            if (nums[i] == a) {
                count++;
                if(count==2){
                    res.add(nums[i]);
                    count=1;
                }
            } else {
                if (count == 2) {
                    res.add(nums[i - 1]);

                }
                count = 1;
                a = nums[i];
            }
        }
        return res;
    }

    //SOLUTION 3
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0){
                if(nums[nums[i] - 1] < 0){
                    result.add(Math.abs(nums[i]));
                }
                else{
                    nums[nums[i] - 1] *= -1;
                }
            }
            else{
                if(nums[Math.abs(nums[i]) - 1] < 0){
                    result.add(Math.abs(nums[i]));
                }
                else{
                    nums[Math.abs(nums[i]) - 1] *= - 1;
                }
            }
        }

        return result;
    }
}
