package leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInString {
    public static int numDifferentIntegers(String word) {
        boolean foundInt=false;
        int count=0;
        String num = "";
        Set<String> set = new HashSet<>();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch-48>=0 && ch-48<=9){
                foundInt=true;
                if(ch-48 ==0 && num!=""){
                    num+=ch-48;
                }
                if(ch-48!=0 ){
                    num+=(ch-48);
                }
            }

            if(ch>='a' && ch<='z'){
                if(foundInt){
                    count++;
                    set.add((num));
                    num="";
                    foundInt=false;
                }
            }
        }
        if( foundInt)
            set.add((num));
        return set.size();
    }
    public static void main(String[] a){
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("gi851a851q8510v"));
    }
}
