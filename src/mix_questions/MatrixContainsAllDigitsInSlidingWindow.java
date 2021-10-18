package mix_questions;

import java.util.HashSet;
import java.util.Set;

public class MatrixContainsAllDigitsInSlidingWindow {


    boolean[] isSubmatrixFull(int[][] numbers) {
        Set<Integer> numSet = generateSet();
        int count=0;
        int sum = 1+2+3+4+5+6+7+8+9;
        boolean res[] = new boolean[numbers[0].length-2];
        for(int i=0;i<numbers[0].length-2;i++){

            if(numSet.contains(numbers[0][i])){

                numSet.remove(numbers[0][i]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }
            if(numSet.contains(numbers[0][i+1])){

                numSet.remove(numbers[0][i+1]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }

            if(numSet.contains(numbers[0][i+2])){

                numSet.remove(numbers[0][i+2]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }

            if(numSet.contains(numbers[1][i])){

                numSet.remove(numbers[1][i]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }
            if(numSet.contains(numbers[1][i+1])){

                numSet.remove(numbers[1][i+1]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }

            if(numSet.contains(numbers[1][i+2])){

                numSet.remove(numbers[1][i+2]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }


            if(numSet.contains(numbers[2][i])){

                numSet.remove(numbers[2][i]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }
            if(numSet.contains(numbers[2][i+1])){

                numSet.remove(numbers[2][i+1]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }

            if(numSet.contains(numbers[2][i+2])){

                numSet.remove(numbers[2][i+2]);
            }else{
                numSet = generateSet();
                res[i]=false;
                continue;
            }

            numSet=generateSet();
            res[i]=true;
        }
        return res;
    }


    public Set<Integer> generateSet(){
        Set<Integer> numSet = new HashSet<>();
        numSet.add(1);
        numSet.add(2);numSet.add(3);numSet.add(4);numSet.add(5);numSet.add(6);numSet.add(7);numSet.add(8);numSet.add(9);

        return numSet;
    }
}
