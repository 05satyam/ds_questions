/*
* You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.

Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.

The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.

You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.

Return the array answer as described above.
*
*
Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
Output: [0,2,0,0,0]
Explanation:
The user with ID=0 performed actions at minutes 5, 2, and 5 again. Hence, they have a UAM of 2 (minute 5 is only counted once).
The user with ID=1 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
Since both users have a UAM of 2, answer[2] is 2, and the remaining answer[j] values are 0.
* */

package leetcode;

import java.util.*;

public class FindUserActiveMinute{

    //SOLUTION 1
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userActiveCnt = new HashMap<Integer, Set<Integer>>();
        for(int i=0;i<logs.length;i++){
            int userId = logs[i][0];
            int minute = logs[i][1];
            //System.out.println("userid: "+ userId+ " , minute "+ minute);
            if(userActiveCnt.containsKey(userId)){
                Set<Integer> userCount = userActiveCnt.get(userId);
                userCount.add(minute);
                userActiveCnt.put(userId, userCount);
            }else{
                Set<Integer> newSet = new HashSet<>();
                newSet.add(minute);
                userActiveCnt.put(userId,newSet);
            }

        }
        /*for(Map.Entry<Integer, Set<Integer>> map: userActiveCnt.entrySet() ){
            System.out.println("map.getKey() "+ map.getKey() + ", map.getValue() "+ map.getValue()) ;
        }*/

        boolean containUserId0 = userActiveCnt.containsKey(0);
        //System.out.println(containUserId0);
        int res[] = new int[k];
        Arrays.fill(res, 0);
        for(Map.Entry<Integer, Set<Integer>> map: userActiveCnt.entrySet() ){
            int key = map.getKey();
            Set<Integer> val = map.getValue();


                  res[val.size()-1] +=  1;

        }
        return res;
    }
    public static void main(String[] a){
        int[][] arr = {{0,5}, {1,2},{0,2},{0,5},{1,3}};
        int[][] arr1 = {{1,1}, {2,2},{2,3}};
        int res[] = findingUsersActiveMinutes(arr1, 4);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }
}
