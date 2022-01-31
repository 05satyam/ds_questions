package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLonelyNUmber {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0)
            return res;
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }

        if(nums.length==2){
            res.add(nums[0]);
            res.add(nums[1]);
            return res;
        }

        Arrays.sort(nums);
        res.add(nums[0]);
        int count=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1]==nums[i]-1 && nums[i+1]==nums[i]+1)
                count++;
            else{
                res.add(nums[i]);
            }
        }
res.add(nums[nums.length-1]);
        return res;
    }
}
