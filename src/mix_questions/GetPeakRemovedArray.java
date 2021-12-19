package mix_questions;

import java.util.ArrayList;
import java.util.List;

public class GetPeakRemovedArray {
   static  int[] solution(int[] numbers) {
        List<Integer> arrList = new ArrayList<>();

        for(int i=0;i<numbers.length;i++){
            arrList.add(numbers[i]);
        }
        int res[] = new int[numbers.length];
        int num=Integer.MAX_VALUE;
        int numIdx=-1;
        if(arrList.size()==1){
           return numbers;
        }
        if(arrList.size()==2){
            if(numbers[1]>=numbers[0]){
                res[0]=numbers[1];
                res[1]=numbers[0];

            }else{
                res[0]=numbers[0];
                res[1]=numbers[1];
            }
            return res;
        }

        int k=1;
        int r=0;
        while(r<numbers.length){
           // System.out.print("arraylist size "+ arrList.size());
          //  System.out.print("   k in start "+ k);
           // System.out.println("   res size "+ res.length);
            for(int i=0; k<arrList.size()-1;i++) {
                System.out.println("get arraylist  "+ arrList.get(k));
                //System.out.println("in loop" + "   arraylist k " + arrList.get(k + 1) + "   "+ arrList.get(k) + "   " + arrList.get(k - 1));
                if ((arrList.get(k + 1) < arrList.get(k)) && (arrList.get(k - 1) < arrList.get(k))) {
                    if (arrList.get(k) < num) {
                        num = arrList.get(k);
                     //   System.out.print( "  num in loop "+ num);
                        numIdx = k;
                    }

                }else if(k==1 && arrList.size()>3){
                    if(arrList.get(k-1)>arrList.get(k)){
                        num=arrList.get(k-1);
                        numIdx=k-1;
                        break;
                    }
                }else if( arrList.size()>3 && num !=Integer.MAX_VALUE) {
                    if(arrList.get(k+1)>arrList.get(k)){
                        num=arrList.get(k+1);
                        numIdx=k+1;
                        break;
                    }
                }else if(arrList.size()==3){
                    if(arrList.get(k)<arrList.get(k+1)){
                        num=arrList.get(k+1);
                        numIdx=k+1;
                        break;
                    }
                }else if(arrList.size()==2){
                    if(arrList.get(k)>arrList.get(k-1)){
                        num=arrList.get(k);
                        numIdx=k;
                        break;
                    }else{
                        num=arrList.get(k-1);
                        numIdx=k-1;
                        break;
                    }

                }else if(arrList.size()==1){

                        num=arrList.get(k-1);
                        numIdx=k-1;
                        break;

                }
                k++;
            }
            System.out.println("arraylist size "+ arrList.size());
            if(arrList.size()==2){
                if(arrList.get(k)>arrList.get(k-1)){
                    num=arrList.get(k);
                    numIdx=k;

                }else{
                    num=arrList.get(k-1);
                    numIdx=k-1;

                }

            }else if(arrList.size()==1){

                num=arrList.get(k-1);
                numIdx=k-1;


            }
           // System.out.println();
            System.out.println(num + "   idx "+ numIdx);
            res[r]=num;
            r++;
            num=Integer.MAX_VALUE;
            if(numIdx!=-1)
            arrList.remove(numIdx);
            //System.out.println("arrlist get "+ arrList.get(numIdx));
            numIdx=-1;
            k=1;


        }

        return res;
    }


    public static void main(String[] a){
        int[] number = new int[9];
        number[0]=2;
        number[1]=7;
        number[2]=8;
        number[3]=5;
        number[4]= 1;
        number[5]=6;
        number[6]=3;
        number[7]=9;
        number[8]=4;
        int []res = solution(number);
        System.out.println(res[0] + "   " + res[1]);



    }
}
