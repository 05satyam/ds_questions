package mix_questions;

/*
* given list of image along with size
* there will be list of list of input
*
* there will be a max size for which image url size will be matched
* if matched return ture along with image url other wise false;
* */

import java.util.*;
import java.util.List;

public class TwilloMachineTestValidateImageQues1 {
    public static void main(String[] args) throws Exception {
        List<List<String>> finalRes = new ArrayList<>();

        List<String> res =new ArrayList<>();
        res.add("https://foo.io/image/happydog");
        res.add("9000000032");
        finalRes.add(res);
        List<List<String>> output = validateImageSize(finalRes, "2GB");
        System.out.println("len out "+ output.size());
        System.out.println("output "+ output.get(0).get(0) + "   " + output.get(0).get(1));

    }

    public static List<List<String>> validateImageSize(List<List<String>> imageUrls, String maxSize) {
        // Write your code here
        Long maxSizeInt = 1000000L;
        char[] sizeArr = maxSize.toCharArray();
        String sizeNum ="";
        if(!maxSize.equalsIgnoreCase("none")){
                for(int i=0;i<sizeArr.length;i++){
                    if(Character.isDigit(sizeArr[i])){
                        sizeNum+=sizeArr[i];
                    }else if(sizeArr[i]=='M' || sizeArr[i]=='m'){
                        System.out.println("sizeNum "+ sizeNum);
                        maxSizeInt = Long.parseLong(sizeNum)*1000000;
                        break;
                    }else if(sizeArr[i]=='G' || sizeArr[i]=='g'){
                        maxSizeInt = Long.parseLong(sizeNum)*100000000;
                        break;
                    }else{
                        maxSizeInt = Long.parseLong(sizeNum)*10000;
                        break;
                    }

                }
                System.out.println("maxSizeInt "+ maxSizeInt);
        }

        List<List<String>> finalRes = new ArrayList<>();
        for(List<String> ll : imageUrls){
            List<String> res =new ArrayList<>();
            String url = ll.get(0);
            String urlSize = ll.get(1);
            res.add(url);
            if(Long.parseLong(urlSize)<=maxSizeInt){

                res.add("TRUE");
            }else{
                res.add("FALSE");
            }

            finalRes.add(res);
        }
        return finalRes;
    }

}
