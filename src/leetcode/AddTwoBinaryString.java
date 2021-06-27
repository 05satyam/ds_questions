/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
package leetcode;

public class AddTwoBinaryString {
    public static String addBinary(String a, String b) {
        if(a==null || a== "")
            return b;
        if(b==null || b=="")
            return a;

        StringBuilder res = new StringBuilder();
        int carry=0;
        int i, j;
        System.out.println((a.length()-1) + "      " + (b.length()-1));
        for( i=a.length()-1, j=b.length()-1; i>=0 && j>=0;i--, j--){
            System.out.println("a.charAt "+ a.charAt(i)  +  "    b.charAt "+ b.charAt(j));
            if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                if(carry==1){
                    res.append("1");
                    carry=1;
                }else {
                    res.append("0");
                    carry=1;
                }
            }else if((a.charAt(i)=='0' && b.charAt(j)=='1') || (a.charAt(i)=='1' && b.charAt(j)=='0')){
                if(carry==1){
                    res.append("0");
                    carry=1;
                }else {
                    res.append("1");
                    carry=0;
                }
            }else{
                if(carry==1){
                    res.append("1");
                    carry=0;
                }else {
                    res.append("0");
                    carry=0;
                }
            }
            System.out.println();
            System.out.println("res in loop  "+ res.toString());
            System.out.println();

        }

        System.out.println("for loop outside i  "+ i);

        System.out.println("for loop outside j  "+ j);
        System.out.println("carry before "+ carry);
        for(;i>=0;i--){
            if(carry==1 && a.charAt(i)=='1'){
                res.append("0");
                carry=1;
            }
           else if(carry==0 && a.charAt(i)=='1'){
                res.append("1");
                carry=0;
            }
            else if(carry==1 && a.charAt(i)=='0'){
                res.append("1");
                carry=0;
            }

          else   if(carry==0 && a.charAt(i)=='0'){
                res.append("0");
                carry=0;
            }

        }


        for(;j>=0;j--){
            if(carry==1 && b.charAt(j)=='1'){
                res.append("0");
                carry=1;
            }
          else  if(carry==0 && b.charAt(j)=='1'){
                res.append("1");
                carry=0;
            }
          else  if(carry==1 && b.charAt(j)=='0'){
                res.append("1");
                carry=0;
            }

         else   if(carry==0 && b.charAt(j)=='0'){
                res.append("0");
                carry=0;
            }

        }


        System.out.println("final carry " + carry);
        if(carry==1)
            res.append("1");



        return  res.reverse().toString();

    }

    //Modified solution 2
    public String addBinary1(String a, String b) {
        boolean carry = false;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder(((i > j) ? i : j) + 1);

        while (i >= 0 || j >= 0) {
            char charA = (i >= 0) ? a.charAt(i--) : '0';
            char charB = (j >= 0) ? b.charAt(j--) : '0';
            if (charA == '1' && charB == '1') { // 1 + 1
                result = (carry) ? result.append('1') : result.append('0');
                carry = true;
            } else if (charA == '0' && charB == '0') { // 0 + 0
                result = (carry) ? result.append('1') : result.append('0');
                carry = false;
            } else {
                result = (carry) ? result.append('0') : result.append('1');
            }
        }

        if (carry) result.append('1');

        return result.reverse().toString();
    }

    public static void main(String[] a){
        System.out.println(addBinary("101111", "10"));
    }
}
