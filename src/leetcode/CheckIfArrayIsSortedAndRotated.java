package leetcode;

public class CheckIfArrayIsSortedAndRotated {
    public static boolean check(int[] nums) {
        int irregularities = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (nums[i] > nums[(i + 1) % length])
                irregularities += 1;
        }
        return irregularities > 1 ? false : true;
    }
    public static void main(String[] a){
        int arr[] = {'2','1','4','5'};
        int arr1[] = {'2','1'};
        int arr2[] = {'1','2','3'};
        int arr3[] = {'3','4','5', '1', '2'};
        System.out.println(check((arr)));
        System.out.println(check((arr1)));
        System.out.println(check((arr2)));
        System.out.println(check((arr3)));
    }
}
