/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetAllCombinationOfCoint {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

            List<Integer> temp = new ArrayList<>();
            helper(candidates, target, 0, res, temp, 0);
        return res;
    }

    public static void helper(int[] arr, int target, int sum, List<List<Integer>> res, List<Integer> temp, int i){
        if(sum==target){
            List<Integer> temp1 = new ArrayList<>(temp);
            res.add(temp1);
            return;
        }
        if(i>= arr.length || sum >target ){
            return;
        }
        if(i>arr.length)
            return;
        System.out.println("i "+ i + "  sum "+ sum  + "  arr_i "+ arr[i]  + "   tempo size "+ temp.size());
        temp.add(arr[i]);
        sum =  sum+arr[i];
        helper(arr, target, sum , res, temp, i);
        int index = temp.size() - 1;
        int a = temp.remove(index);
        sum -= a;
        helper(arr, target, sum, res,temp, i+1);
        //i--;

    }
    public static void main(String[] a){
        int arr[] = {2,3,6,7};
        List<List<Integer>> res = combinationSum(arr, 7);
        System.out.println("output");
        for(List<Integer> res1: res){
            for(Integer i : res1){
                System.out.print(" "+ i);
            }
            System.out.println("new set");
        }
        System.out.println("res size "+ res.size());
    }
}
