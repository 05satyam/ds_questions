package mix_questions;

public class MergingLetters {
    static String mergingLetters(String s, String t) {

        if(s.length()==0)return t;

        if(t.length()==0) return s;


        StringBuilder res = new StringBuilder();
        int i=0, j=0;
        for( i=0, j=0;j<t.length() && i<s.length(); i++, j++){

            res.append(s.charAt(i));
            res.append(t.charAt(j));
        }

        if(i<s.length()){
            res.append(s.substring(i,s.length()));
            return res.toString();
        }

        if(j<t.length()){
            res.append(t.substring(j,t.length()));
            return res.toString();
        }

        return res.toString();


    }



    public static void main(String[] a){
        System.out.print(mergingLetters("ab", "abcdef"));
    }
}
