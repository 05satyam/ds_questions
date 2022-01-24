/*
You are given a string that represents time in the format hh:mm. Some of the digits are blank (represented by ?). Fill in ? such that the time represented by this string is the maximum possible. Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
* */
package leetcode.google;

public class MaximumTime {
    public static void giveMeMaxTime(String tim){
        char[] time = tim.toCharArray();
        if(time[0]=='?'){
            time[0]= (time[1]<='3'|| time[1] == '?')?'2':'1';
        }

        if(time[1]=='?'){
            time[1]= time[0]=='2'?'3':'9';
        }

        time[3]=time[3]=='?'?'5':time[3];
        time[4]=time[4]=='?'?'9':time[4];
    }

    public int minCostClimbingStairs(int[] cost) {

        if(cost.length==0)
            return 0;
        if(cost.length==1)
            return cost[0];
        if(cost.length==2){
            return  Math.max(cost[0], cost[1]);
        }

        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;

        for(int i=2;i<=cost.length;i++){
            dp[i]= Math.max(cost[i]+dp[i-1], cost[i]+ dp[i-2]);
        }

        return dp[cost.length];
    }

}
