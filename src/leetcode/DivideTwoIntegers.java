package leetcode;

import java.util.*;

public class DivideTwoIntegers {
    public static  int pivotIndex(int[] nums) {
        int numLen = nums.length;
        int l2r[]= new int[numLen];
        int r2l[] = new int[numLen];
        l2r[0]=0;
        for(int i=1;i< numLen;i++){
            l2r[i] = l2r[i-1]+ nums[i-1];
        }

        r2l[numLen-1]=0;
        for(int i=numLen-2;i>=0;i--){
           r2l[i] = r2l[i+1] + r2l[i+1];
        }

return 0;
    }
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> maping = new HashMap<>();
        Map<Character, Character> maping1 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(maping.containsKey(s.charAt(i)) && maping.get(s.charAt(i))!= t.charAt(i))
                return false;
            else {
                if(maping1.containsKey(t.charAt(i)))
                    return false;
                maping.put(s.charAt(i), t.charAt(i));

                maping1.put(t.charAt(i), s.charAt(i));
            }


        }
        return true;
    }
    public static void main(String[] a){
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
