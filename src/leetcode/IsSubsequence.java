package leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char cur[]=s.toCharArray();
        //Initial value of past is -2 to avoid match at 0th index
        int past=-2;
        for(char c:cur){
            //Every time we update the last match index +1 in past
            past=t.indexOf(c,past+1);
            //If no match found -1 will be returned,so returning false
            if(past==-1)
                return false;
        }
        //If the string s is traversed completely ,then return true
        return true;
    }
}
