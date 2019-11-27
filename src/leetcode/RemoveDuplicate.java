/**
 * 
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * */

package leetcode;

public class RemoveDuplicate {

	 public int removeDuplicates(int[] nums) {
	        if(nums==null){
	        return 0;
	    }
	    if(nums.length<3){
	        return nums.length;
	    }
	    int i=0;
	    int j=1;
	    while(j<nums.length){
	        if(nums[j]==nums[i]){
	            if(i==0){
	                i++;
	                j++;
	            }else if(nums[i]==nums[i-1]){
	                j++;
	            }else{    
	                i++;
	                nums[i]=nums[j];
	                j++;
	            }
	        }else{
	            i++;
	            nums[i]=nums[j];
	            j++;
	        }
	    }
	 
	    return i+1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
