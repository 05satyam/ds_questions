/*
* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

* */
package leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    //SOLUTION 1
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1] > nums2[p2]){
                for(int i = m-1; i>=p1; i--){
                    nums1[i+1] = nums1[i];
                }
                nums1[p1] = nums2[p2];
                p2++;
                m++;
            }
            else{
                p1++;
            }
        }
        while(p2 < n){
            nums1[m] = nums2[p2];
            p2++;
            m++;
        }
    }


    //SOLUTION 2
    public void merge1(int[] nums1, int m, int[] nums2, int n)
    {
        int k=0;
        for(int i=m;i<nums1.length;i++)
        {
            nums1[m++]=nums2[k];
            k++;
        }
        Arrays.sort(nums1);
    }
}
