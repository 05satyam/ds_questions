/*
You are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|.

Return the maximum distance.

 

Example 1:

Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Example 2:

Input: arrays = [[1],[1]]
Output: 0
 
*/

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
      int arraysLen = arrays.size();
      
      int minVal=arrays.get(0).get(0);
      int n = arrays.get(0).size();
      int maxVal = arrays.get(0).get(n-1);

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<arraysLen;i++){
              n = arrays.get(i).size();
           int diff = Math.max( Math.abs(arrays.get(i).get(n-1) - minVal),
            Math.abs(maxVal - arrays.get(i).get(0)));

            ans = Math.max(diff, ans);

            minVal = Math.min(minVal, arrays.get(i).get(0));
            maxVal = Math.max(maxVal, arrays.get(i).get(arrays.get(i).size()-1));
        } 
     
        return ans;
    }
}
