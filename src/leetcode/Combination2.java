/**
 * QUESTION:
 * 
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
	The same repeated number may be chosen from candidates unlimited number of times.
	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
 * */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination2 {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<>();
	    List<Integer> temp = new ArrayList<>();
	    helper(candidates, 0, target, 0, temp, result);
	    return result;
	}
	 
	private static void helper(int[] candidates, int start, int target, int sum,
	                    List<Integer> list, List<List<Integer>> result){
	    if(sum>target){
	        return;
	    }
	 
	    if(sum==target){
	        result.add(new ArrayList<>(list));
	        return;
	    }
	 
	    for(int i=start; i<candidates.length; i++){
	        list.add(candidates[i]);
	        helper(candidates, i, target, sum+candidates[i], list, result);
	        list.remove(list.size()-1);
	    }
	}
	public static void main(String[] args) {

		int arr[] = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(combinationSum(arr, 8).toString());
	}

}
