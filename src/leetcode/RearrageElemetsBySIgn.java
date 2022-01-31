/*
* You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.


*
* Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
*
*
*
* */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RearrageElemetsBySIgn {
    public static int[] rearrangeArray(int[] nums) {
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        int[] res  = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                positiveList.add(nums[i]);
            else
                negativeList.add(nums[i]);
        }
        int pSize=0;
        int nSize=0;
        //System.out.println("positive size "+ positiveList.size() + "    negative size "+ negativeList.size());
        for(int i=0,j=0, k=0;k<nums.length-1;){
            if(positiveList.size()>pSize){
                //System.out.println("positive "+ positiveList.get(i));
                res[k]=positiveList.get(i);
                k++;
                i++;
                pSize++;
            }

            if(negativeList.size()>nSize) {
                //System.out.println("negative" + negativeList.get(j) + "   k  "+ k);
                res[k] = negativeList.get(j);
                k++;
                j++;
                nSize++;
            }
        }
        return res;
    }

    public static void main(String[] a){
        int[] nums={3,1,-2,-5,2,-4};
        int[] res = rearrangeArray(nums);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + "  ");

        }
        System.out.println();
    }
}
