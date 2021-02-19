package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i=i+2){
            int first = nums[i];
            int second = nums[i+1];
            for(int j=0;j<first;j++){
                res.add(second);
            }
        }
        int [] ints = res.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }
    public static void main(String a[]){

    }
}
