package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWord {
    public static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb  = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            StringBuilder sbStr = new StringBuilder();
            boolean found = false;
            for(int j=0;j<words[i].length();j++){
                sbStr.append(words[i].charAt(j));
                if(dictionary.contains(new String(sbStr))) {
                    sb.append(sbStr);
                    found=true;
                    break;
                }
            }
            if(!found)
                sb.append(words[i]);
            if(i!=words.length-1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] a){
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        System.out.println(replaceWords(dict, "the cattle was rattled by the battery"));
    }
}
