package mix_questions;

public class FindOccuranceOfWordInSequence {
    static int[] maxKOccurrences(String str, String[] words) {
        int res[] = new int[words.length];
        for(int i=0;i<words.length;i++){
            int count = 0;
            StringBuilder subStr = new StringBuilder();
            subStr.append(words[i]);
            System.out.print("words[" +i+"] "+ words[i]);
            for(int j=1;j<str.length();j++){
                if(str.contains(subStr)){
                    System.out.print("     found substr" + subStr);
                    subStr.append(words[i]);
                    count++;
                }else{
                    break;
                }

                System.out.print("   new substr "+ subStr);
            }
            System.out.print("   count "+ count);
            res[i]=count;

            System.out.println();

        }

        return res;
    }

    public static void main(String[] a){
        String[] words = new String[3];
        words[0] ="ab";
        words[1] = "babc";
        words[2]="bca";

        System.out.print(maxKOccurrences("ababcbabc" , words));
    }
}
