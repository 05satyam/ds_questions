package leetcode;

import java.util.Arrays;

public class BuddyString {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] goalArr = goal.toCharArray();
        int[] count = new int[26];
        boolean moreThanOneChar = false;
        char moreChar = 0;
        Arrays.fill(count, 0);
        for(int i=0;i<sArr.length;i++){
            if(moreChar!=sArr[i]){
               moreThanOneChar=true;
            }
            count[sArr[i]-'a']++;
            count[goalArr[i]-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0)
                return false;
        }

        return moreThanOneChar?(s.equalsIgnoreCase(goal)?false:true):false;
    }
}
