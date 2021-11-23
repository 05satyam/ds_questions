package mix_questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FlexPortTest {
    //q1
    public static int find_mistake(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int r=-1;
        int sum=0;
        int actSum=0;
        int k=1;
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])){
                r=nums[i];
            }else{
                s.add(nums[i]);
            }

            sum+=nums[i];
            actSum+=k;
            k++;
        }
System.out.println(actSum +  "   "+ sum +   "  "  +  r  );
        return (r + (sum-(actSum-r)));
    }

//q2
    public static int almost_palindrome(String str) {
        int count=0;
        for(int i=0, j=str.length()-1;i<str.length()/2;i++, j--){
            if(str.charAt(i)!=str.charAt(j))
                count++;
        }

        return (count*2);
    }

//q3
    public static boolean can_reach_end(int[] nums) {
        int i;
        for(i=0;i<nums.length;){
            int a=nums[i];
            if(a!=0){
                i=i+a;
            }else{
               return false;
            }
        }

        if(i>=nums.length)
            return true;
        return false;
    }
}