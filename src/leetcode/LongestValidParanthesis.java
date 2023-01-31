/***\
 * As of now not working for all testcases
 *
 */
package leetcode;

import java.util.Stack;

public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        Stack<Character> sc = new Stack<>();
        int currSize=0, maxSize=0;
        for(Character c  :  s.toCharArray()){
            //System.out.println(c!=')');
            if(sc.size()==0){
                if(c==')'){
                    maxSize=maxSize<currSize?currSize:maxSize;
                    currSize=0;
                }
                else{
                    System.out.println(c);
                    sc.push(c);
                    //currSize++;
                }
            }else{
                if(c==')' && sc.peek()=='('){
                    System.out.println(c);
                    currSize+=2;
                    sc.pop();
                }else if(c=='(' && sc.peek()=='('){
                    sc.push(c);
                }
                //maxSize=maxSize<currSize?currSize:maxSize;
            }
        }
        return maxSize;
    }
    public static void main(String[] a){
        LongestValidParanthesis obj=new LongestValidParanthesis();
        System.out.println(obj.longestValidParentheses("()(()"));
    }
}
