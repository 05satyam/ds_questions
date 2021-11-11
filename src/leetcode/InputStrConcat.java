package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputStrConcat {
    String equallyRearranging(String inputStr) {
        StringBuilder res =new StringBuilder();
        int count=0;
        int w=0, d=0,l=0;
        char[] chars = inputStr.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='W')
                w++;

            if(chars[i]=='D')
                d++;

            if(chars[i]=='L')
                l++;

        }

        for(int i=0;i<chars.length;i=i+1){
            if(w==0 && d==0 && l==0)
                break;

            if(w>0){
                res.append("W");
                w--;
            }

            if(d>0){
                res.append("D");
                d--;
            }

            if(l>0){
                res.append("L");
               l--;
            }
        }
return res.toString();
    }
}
