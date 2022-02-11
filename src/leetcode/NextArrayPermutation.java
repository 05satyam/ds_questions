package leetcode;

public class NextArrayPermutation {
    public void nextPermutation(int[] nums) {
            for(int i=nums.length-1;i>0;i--){
                for(int j=i;j>0;j--){
                    if(nums[j]>nums[j-1]){
                        int temp=nums[j];
                        nums[j]=nums[j-1];
                        nums[j-1]=temp;

                    }
                }
            }
    }
}
