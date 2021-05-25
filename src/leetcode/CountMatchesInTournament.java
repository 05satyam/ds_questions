/*
*
* You are given an integer n, the number of teams in a tournament that has strange rules:

If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
Return the number of matches played in the tournament until a winner is decided.



Example 1:

Input: n = 7
Output: 6
Explanation: Details of the tournament:
- 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
- 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
- 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
Total number of matches = 3 + 2 + 1 = 6.
* */

package leetcode;

public class CountMatchesInTournament {
    public static int numberOfMatches(int n) {
        return numberOfMatche(n,0);
    }
    public static int numberOfMatche(int n, int matches) {
        if(n==1){
            return matches;
        }
        int totalMatchesTillNow  = matches + (n/2);
        System.out.println("totalMatchesTillNow 1: " + totalMatchesTillNow);
        if(n%2==0){
          return   numberOfMatche(n/2, totalMatchesTillNow);
        }else{
          return   numberOfMatche(((n/2)+1), totalMatchesTillNow);
        }
        //System.out.println("totalMatchesTillNow 2: "+ totalMatchesTillNow);
       //return totalMatchesTillNow;
    }

    public static void main(String[] a){
        System.out.println(numberOfMatches(7));
    }
}
