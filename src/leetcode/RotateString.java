package leetcode;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.equalsIgnoreCase(goal))
            return true;
        for(int i=0;i<s.length();i++){
            if(getRoatateString(s, i).equalsIgnoreCase(goal))
                return true;
        }
        return false;
    }
    public String getRoatateString(String s, int i){
        return  s.substring(i)+ s.substring(0,i);
    }

    //SOLUTION 2
    public boolean rotateString2(String A, String B) {

        return(A.length() == B.length() && (A + A).contains(B));

    }
}
