package mix_questions;

public class CountNumberOfSubstringDivisibleBy3 {
    static int solution(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            for (int j = i; j < number.length(); j++) {
                String subStr = number.substring(i, j + 1);
                System.out.println("substr "+ subStr);
                if (Integer.valueOf(subStr) % 3 == 0 && Integer.valueOf(subStr.substring(0,1))!=0 ) {
                    count++;

                    System.out.println("count "+ count);
                }else if(subStr.length()==1 && Integer.valueOf(subStr)==0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] a){
        System.out.println(solution("303"));
    }
}
