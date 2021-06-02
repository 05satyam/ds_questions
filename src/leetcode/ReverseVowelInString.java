/*
* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.



Example 1:

Input: s = "hello"
Output: "holle"
* */

package leetcode;

public class ReverseVowelInString {
    public static String reverseVowels(String s) {
        char[] ch=s.toCharArray();
        for(int i=0,j=s.length()-1;i<j;){
            if(isVowel(ch[i], i)){
                System.out.println("i is vowel "+ ch[i]);
                if(isVowel(ch[j], j)){
                    System.out.println("j is vowel "+ ch[j]);
                    char temp  =ch[i];
                    ch[i]=ch[j];
                    ch[j]=temp;
                    i++;
                    j--;
                }else{
                    System.out.println("j--");
                    j--;
                }
            }else{
                System.out.println("i--");
                i++;
            }
        }
        return String.valueOf(ch);
    }

    static boolean isVowel(char s, int i){
        if(s=='a' ||s=='e' || s=='i' || s=='o' || s=='u' || s=='A' ||s=='E' || s=='I' || s=='O' || s=='U') return true;
        return false;
    }

    public static void main(String[] a){
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("aA"));
    }
}
