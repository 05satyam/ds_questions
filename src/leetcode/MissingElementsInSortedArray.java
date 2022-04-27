package leetcode;

public class MissingElementsInSortedArray {
    public int missingElement(int[] nums, int k) {
        int missingCnt=0;
        int i=0;
        for( i=1;i<nums.length;i++){
            missingCnt += nums[i]-nums[i-1]-1;
            if(missingCnt<k){
                //k=k-missingCnt;
                continue;
            }
            if(missingCnt>=k)
                break;

        }

        return (nums[i-1]+(missingCnt-k));

    }
}
