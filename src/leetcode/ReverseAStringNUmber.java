/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
package leetcode;

public class ReverseAStringNUmber {
    public int reverse(int x) {
        int rev = 0;
        boolean neg=false;
        int x1=x;
        if(x<0){
            neg=true;
            x= x*(-1);
        }
        int prevRevNum = 0, revNum = 0;
        while (x != 0)
        {
            int curr_digit = x%10;

            revNum = (revNum*10) + curr_digit;
            if ((revNum - curr_digit)/10 != prevRevNum) {
                return 0;
            }

            prevRevNum = revNum;
            x = x/10;
        }

        return neg?(-1)*revNum: revNum;
    }

}
