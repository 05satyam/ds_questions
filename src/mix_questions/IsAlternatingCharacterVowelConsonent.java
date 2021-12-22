package mix_questions;

import java.util.HashSet;
import java.util.Set;

public class IsAlternatingCharacterVowelConsonent {
   static  int solution(String inputStr) {

        Set<Character> vowel = new HashSet<>();
        String lastCharVowel="";
        vowel.add('a');vowel.add('e');vowel.add('i');vowel.add('o');vowel.add('u');vowel.add('y');
        for(int i=0;i<inputStr.length();i++){
            System.out.println(inputStr.charAt(i));
            if(i==0 && vowel.contains(inputStr.charAt(i))){
                lastCharVowel="vowel";
            }else if(i==0 && !vowel.contains(inputStr.charAt(i))){
                lastCharVowel="nan";
            }else {
                System.out.println("last char "+ lastCharVowel);
                if(vowel.contains(inputStr.charAt(i)) && lastCharVowel.equalsIgnoreCase("vowel")){
                    return i;
                }

                if(!vowel.contains(inputStr.charAt(i)) && lastCharVowel.equalsIgnoreCase("nan")){
                    return i;
                }

                if(vowel.contains(inputStr.charAt(i)) && !lastCharVowel.equalsIgnoreCase("vowel")){
                    lastCharVowel="vowel";
                    continue;
                }

                if(!vowel.contains(inputStr.charAt(i)) && lastCharVowel.equalsIgnoreCase("vowel")){
                    lastCharVowel="nan";
                    continue;
                }
            }

        }
        return -1;
    }


    public static void main(String[] a){
       System.out.println(solution("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp"));
    }
}
