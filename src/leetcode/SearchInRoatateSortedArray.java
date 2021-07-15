package leetcode;

public class SearchInRoatateSortedArray {
    public static int search(int[] nums, int target) {

        int start=0;
        int last=nums.length;
        int mid=0;
        int idx=-1;

        while(start<last){
            mid=(start+last)/2;
            System.out.println("mid "+ mid);
            if(nums[mid]==target){
                return mid;
            }
            System.out.println("nums mid "+ nums[mid]);
            if(nums[mid]>target){
                start=mid+1;
            }else{
                last=mid-1;
            }

            System.out.println("start "+ start + "     last "+ last);
        }
        return idx;
    }

    public static void main(String[] a){
        int[] nums=new int[7];
        nums[0]=4;
        nums[1]=5;
        nums[2]=6;
        nums[3]=7;
        nums[4]=0;
        nums[5]=1;
        nums[6]=2;
        System.out.println(search(nums, 0));
    }
}
