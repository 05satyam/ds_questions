package mix_questions;

public class CountSubStringInString {
    //titi+2ti+4 = s.
    static int solution(String t, String s) {
        int count=0;

        for(int i=0;i<t.length()-3;i=i+1){
            StringBuilder sb = new StringBuilder();
            sb.append(t.charAt(i));
            sb.append(t.charAt(i+2));
            sb.append(t.charAt(i+4));
            System.out.println("sb : "+ sb.toString());
            if(sb.toString().equalsIgnoreCase(s))
                count++;
        }

        return count;
    }

    public static void main(String[] s){
        System.out.println(solution("azcabcab","acb"));
    }
}
