package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountItemMatchingRule {

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleIdx = -1;
        if(ruleKey.equalsIgnoreCase("type"))
            ruleIdx=0;
        else if(ruleKey.equalsIgnoreCase("color"))
            ruleIdx=1;
        else if(ruleKey.equalsIgnoreCase("name"))
            ruleIdx=2;

        int count=0;
        for(int i=0;i<items.size();i++){
            List<String> itemList = items.get(i);
            if(ruleIdx!=-1 && itemList.get(ruleIdx).equalsIgnoreCase(ruleValue))
                count++;
        }
        return count;
    }

    public static void main(String[] a){
        List<List<String>> items = new ArrayList<>();

        List<String> item = new ArrayList<>();
        item.add("phone");
        item.add("blue");
        item.add("pixel");

        items.add(item);
        System.out.println(countMatches(items, "color", "blue"));
    }
}
