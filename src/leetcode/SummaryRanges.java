package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length==0)
            return res;

        if(nums.length==1){
            res.add(nums[0]+"");
            return  res;
        }
        int strt=-1;
        int nd = nums[0];

        for(int i=1;i<nums.length;i++){
            int a = nums[i];
            if(a==nd+1){
                nd=a+1;
                continue;
            }else{
                strt=nd;
               nd=nd-1;
            }
            if(strt!=nd){
                res.add(strt+"->"+nd);
            }
        }
        return res;
    }
}
