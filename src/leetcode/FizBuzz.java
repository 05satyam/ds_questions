/*
* Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.


Example 1:

Input: n = 3
Output: ["1","2","Fizz"]

* */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0) {
                res.add("FizzBuzz");
                continue;
            }

            if(i%3==0){
                res.add("Fizz");
                continue;
            }
            if(i%5==0){
                res.add("Buzz");
                continue;
            }
        }
        return res;
    }
}
